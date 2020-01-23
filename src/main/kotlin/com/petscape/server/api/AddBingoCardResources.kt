package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.BingoCard
import com.petscape.server.models.BingoGame
import com.petscape.server.utils.generateSquares
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.findOneById
import org.litote.kmongo.replaceOneById
import org.litote.kmongo.util.idValue
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/bingo/add_card")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class AddBingoCardResource(private val db: MongoDatabase) {

    @POST
    fun addBingoCard(
        @QueryParam("id") @NotEmpty gameId: String,
        @QueryParam("name") @NotEmpty username: String
    ) : BingoCard {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        val game = games.findOneById(gameId)

        if (game == null) {
            throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
        } else if (game.cards.any { it.username == username }) {
            throw WebApplicationException("Card already exists for that user in this game", Response.Status.FORBIDDEN)
        }

        val card = BingoCard()
        card.username = username

        if (game.parentCard != null) {
            card.squares = game.parentCard
        } else {
            card.squares = generateSquares(db, game.type, game.freeSpace)
        }

        game.cards.add(card)
        games.replaceOneById(gameId, game)

        return card
    }
}