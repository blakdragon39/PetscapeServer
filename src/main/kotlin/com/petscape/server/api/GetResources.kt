package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.BingoCard
import com.petscape.server.models.BingoGame
import com.petscape.server.models.BingoSquare
import com.petscape.server.utils.FileUtils
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.annotation.security.PermitAll
import javax.imageio.ImageIO
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/bingo/get_card")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class GetCardResource(private val db: MongoDatabase) {

    @GET
    fun getCard(@QueryParam("game_id") @NotNull gameId: ObjectId,
                @QueryParam("username") @NotEmpty username: String): BingoCard {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        return game.cards.find { it.username == username } ?: throw WebApplicationException("Card not found", Response.Status.NOT_FOUND)
    }
}


@Path("/bingo/get_card_image")
@Produces("image/png")
@PermitAll
class GetCardImageResource(private val db: MongoDatabase) {

    private val imageSize = 600
    private val squareSize = imageSize / 5

    @GET
    fun getImage(@QueryParam("game_id") @NotNull gameId: ObjectId,
                 @QueryParam("username") @NotEmpty username: String): Response {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        val card = game.cards.find { it.username == username } ?: throw WebApplicationException("Card not found", Response.Status.NOT_FOUND)
        val imageData = generateImage(card)

        return Response.status(200)
                .header("Content-Length", imageData.size)
                .header("Cache-Control", "max-age=86400, public")
                .entity(imageData)
                .type("image/png")
                .encoding("image/png").build()
    }

    private fun generateImage(card: BingoCard): ByteArray {
        val image = BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB)
        var x = 0
        var y = 0

        card.squares?.forEach { square ->
            val squareImage = generateSquareImage(square)
            image.graphics.drawImage(squareImage, x, y, squareSize, squareSize, null)

            x += squareSize
            if (x >= imageSize) {
                x = 0
                y += squareSize
            }
        }

        val baos = ByteArrayOutputStream()
        ImageIO.write(image, "png", baos)
        return baos.toByteArray()
    }

    private fun generateSquareImage(square: BingoSquare): BufferedImage {
        val image = BufferedImage(squareSize, squareSize, BufferedImage.TYPE_INT_ARGB)
        image.createGraphics().apply {
            color = Color.BLACK
            drawRect(0, 0, squareSize - 1, squareSize - 1)
        }

        //todo boss, boss + item, item, task, free space
        if (square.boss != null) {
            val bossImageSize = squareSize - 4
            val bossImage = ImageIO.read(FileUtils.loadBoss(square.boss!!))

            if (bossImage.height < bossImage.width) {
                val scale = bossImage.height.toFloat() / bossImage.width.toFloat()
                val scaledHeight = (bossImageSize * scale).toInt()
                val offset = (squareSize - scaledHeight) / 2
                image.graphics.drawImage(bossImage, 2, offset, bossImageSize, scaledHeight, null)
            } else {
                val scale = bossImage.width.toFloat() / bossImage.height.toFloat()
                val scaledWidth = (bossImageSize * scale).toInt()
                val offset = (squareSize - scaledWidth) / 2
                image.graphics.drawImage(bossImage, offset, 2, scaledWidth, bossImageSize, null)
            }
        }

        return image
    }
}

@Path("/bingo/winners")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class GetWinnersResource(private val db: MongoDatabase) {

    @GET
    fun getWinners(@QueryParam("game_id") @NotNull gameId: ObjectId): List<BingoCard> {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        return game.winners()
    }
}