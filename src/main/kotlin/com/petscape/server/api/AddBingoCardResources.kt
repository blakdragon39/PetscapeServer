package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.*
import com.petscape.server.utils.generateSquares
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById
import org.litote.kmongo.replaceOneById
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/bingo/add_card")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class AddBingoCardResource(private val db: MongoDatabase) {

    @POST
    fun addBingoCard(
        @QueryParam("id") @NotNull gameId: ObjectId,
        @QueryParam("username") @NotEmpty username: String
    ) : BingoCardModel {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGameMongo::class.java)
        val game = games.findOneById(gameId)

        if (game == null) {
            throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        } else if (game.cards.any { it.username?.toLowerCase() == username.toLowerCase() }) {
            throw WebApplicationException("Card already exists for that user in this game", Response.Status.FORBIDDEN)
        }

        val card = BingoCardMongo()
        card.username = username

        if (game.parentCard != null) {
            card.squares = game.parentCard
        } else {
            card.squares = generateSquares(game.type, game.freeSpace)
        }

        game.cards.add(card)
        games.replaceOneById(gameId, game)

        return card.toModel()
    }
}