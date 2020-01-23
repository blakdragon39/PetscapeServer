package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.*
import com.petscape.server.utils.generateSquares
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/bingo/new_game")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class NewBingoGameResource(private val db: MongoDatabase) {

    @POST
    fun createBingoGame(
        @QueryParam("name") @NotEmpty name: String,
        @QueryParam("type") @NotEmpty type: String,
        @QueryParam("free_space") @NotEmpty freeSpace: String,
        @QueryParam("cards_match") @NotEmpty cardsMatch: String
    ): BingoGame {
        validateType(type)

        val game = BingoGame()
        game.name = name
        game.cards = mutableListOf()
        game.type = BingoGameType.valueOf(type)
        game.freeSpace = freeSpace.toBoolean()

        if (cardsMatch.toBoolean()) {
            game.parentCard = generateSquares(db, game.type, freeSpace.toBoolean())
        }

        db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java).insertOne(game)
        return game
    }
}

@Path("/bingo/new_custom_game")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class NewCustomBingoGameResource(private val db: MongoDatabase) {

    @POST
    fun createBingoGame(
        @QueryParam("name") @NotEmpty name: String
    ): BingoGame {
        val game = BingoGame()
        game.name = name
        game.cards = mutableListOf()
        game.type = BingoGameType.OTHER

        //todo create parent card based off input

        return game
    }
}

private fun validateType(type: String) {
    val validTypes = listOf(BingoGameType.BOSSES, BingoGameType.ITEMS, BingoGameType.COMBINED)
    if (validTypes.none { it.toString() == type })
        throw WebApplicationException("type must be one of $validTypes}", Response.Status.BAD_REQUEST)
}