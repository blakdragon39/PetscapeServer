package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.BingoCard
import com.petscape.server.models.BingoGame
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById
import javax.annotation.security.PermitAll
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