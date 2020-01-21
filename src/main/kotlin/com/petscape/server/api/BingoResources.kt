package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.models.BingoGame
import com.petscape.server.models.BingoGameType
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
        @QueryParam("cards_match") cardsMatch: Boolean = false
    ): BingoGame {
        validateType(type)

        val game = BingoGame()
        game.name = name
        game.cards = emptyList()
        game.type = BingoGameType.valueOf(type)

        //todo if cards match, generate parent card

        return game
    }

    private fun validateType(type: String) {
        return when (type) {
            BingoGameType.BOSSES.toString() -> Unit
            BingoGameType.ITEMS.toString() -> Unit
            else -> throw WebApplicationException("type must be one of BOSSES or ITEMS", Response.Status.BAD_REQUEST)
        }
    }
}