package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.COLLECTION_BOSSES
import com.petscape.server.models.*
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import kotlin.random.Random

private const val NUM_SQUARES = 25
private const val FREE_SQUARE = 12

@Path("/bingo/new_game")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class NewBingoGameResource(private val db: MongoDatabase) {

    @POST
    fun createBingoGame(
        @QueryParam("name") @NotEmpty name: String,
        @QueryParam("type") @NotEmpty type: String,
        @QueryParam("free_space") freeSpace: String,
        @QueryParam("cards_match") cardsMatch: String
    ): BingoGame {
        validateType(type)

        val game = BingoGame()
        game.name = name
        game.cards = emptyList()
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
        game.cards = emptyList()
        game.type = BingoGameType.OTHER

        //todo create parent card based off input

        return game
    }
}

// todo Resource: add card to game
// todo using parent card
// todo using random card

private fun validateType(type: String) {
    val validTypes = listOf(BingoGameType.BOSSES, BingoGameType.ITEMS, BingoGameType.COMBINED)
    if (validTypes.none { it.toString() == type })
        throw WebApplicationException("type must be one of $validTypes}", Response.Status.BAD_REQUEST)
}

private fun generateSquares(db: MongoDatabase, type: BingoGameType, freeSpace: Boolean): List<BingoSquare> {
    val squares = mutableListOf<BingoSquare>()
    val choices = getSquareChoices(db, type).toMutableList()

    for (i in 0 until NUM_SQUARES) {
        //todo check if free square
        val index = Random.Default.nextInt(choices.size)
        val choice = if (type != BingoGameType.BOSSES) choices.removeAt(index) else choices[index]
        val square = BingoSquare()

        when (type) {
            BingoGameType.BOSSES -> square.boss = choice as LiteBoss
            BingoGameType.ITEMS -> square.item = choice as Drop
            BingoGameType.COMBINED -> {
                val pair = choice as Pair<*, *>
                square.boss = pair.first as LiteBoss
                square.item = pair.second as Drop
            }
            else -> Unit
        }

        squares.add(square)
    }

    return squares
}

private fun getSquareChoices(db: MongoDatabase, type: BingoGameType): List<Any> {
    val bosses = db.getCollection(COLLECTION_BOSSES, Boss::class.java).find().toList()

    return when (type) {
        BingoGameType.BOSSES -> bosses.map { it.toLiteBoss() }
        BingoGameType.ITEMS -> {
            bosses.flatMap { it.drops }
        }
        BingoGameType.COMBINED -> {
            return bosses.flatMap { boss ->
                boss.drops.map { drop ->
                    Pair(boss.toLiteBoss(), drop)
                }
            }
        }
        else -> emptyList()
    }
}