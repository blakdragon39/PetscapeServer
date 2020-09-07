package com.petscape.server.bingo

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.bingo.models.BingoCardMongo
import com.petscape.server.bingo.models.BingoGameMongo
import com.petscape.server.bingo.models.BingoGameType
import com.petscape.server.bingo.models.BingoSquareMongo
import com.petscape.server.models.*
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response
import kotlin.random.Random

const val BINGO_NUM_SQUARES = 25
private const val FREE_SQUARE = 12

fun getGame(db: MongoDatabase, gameId: ObjectId): BingoGameMongo {
    val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGameMongo::class.java)
    return games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
}

fun getCard(db: MongoDatabase, gameId: ObjectId, username: String): BingoCardMongo {
    val game = getGame(db, gameId)
    return game.cards.find { it.username == username } ?: throw WebApplicationException("Card not found", Response.Status.NOT_FOUND)
}

fun generateSquares(type: BingoGameType, freeSpace: Boolean): List<BingoSquareMongo> {
    val squares = mutableListOf<BingoSquareMongo>()
    val choices = getSquareChoices(type).toMutableList()

    for (i in 0 until BINGO_NUM_SQUARES) {
        val square = if (freeSpace && i == FREE_SQUARE) {
            BingoSquareMongo.FreeSquare
        } else {
            val index = Random.Default.nextInt(choices.size)
            val choice = if (type != BingoGameType.BOSSES) choices.removeAt(index) else choices[index]
            val square = BingoSquareMongo()

            when (type) {
                BingoGameType.BOSSES -> square.boss = choice as Boss
                BingoGameType.ITEMS -> square.item = choice as Drop
                BingoGameType.COMBINED -> {
                    val pair = choice as Pair<*, *>
                    square.boss = pair.first as Boss
                    square.item = pair.second as Drop
                }
                else -> Unit
            }

            square
        }

        squares.add(square)
    }

    return squares
}

private fun getSquareChoices(type: BingoGameType): List<Any> {
    val bosses = Boss.values().toList()

    return when (type) {
        BingoGameType.BOSSES -> bosses
        BingoGameType.ITEMS -> getItems(bosses)
        BingoGameType.COMBINED -> {
            return bosses.flatMap { boss ->
                boss.drops.map { drop ->
                    Pair(boss, drop)
                }
            }
        }
        else -> emptyList()
    }
}

fun getItems(bosses: List<Boss>): List<Drop> {
    val items = bosses
        .flatMap { it.drops }
        .map { it.first }
    return items.distinctBy(Drop::item)
}