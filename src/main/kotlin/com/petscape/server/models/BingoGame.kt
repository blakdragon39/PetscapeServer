package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

val WINNING_LINES = listOf(
        listOf(0, 1 , 2, 3, 4),
        listOf(5, 6, 7, 8, 9),
        listOf(10, 11, 12, 13, 14),
        listOf(15, 16, 17, 18, 19),
        listOf(20, 21, 22, 23, 24),
        listOf(0, 5, 10, 15, 20),
        listOf(1, 6, 11, 16, 21),
        listOf(2, 7, 12, 17, 22),
        listOf(3, 8, 13, 18, 23),
        listOf(4, 9, 14, 19, 24),
        listOf(0, 6, 12, 18, 24),
        listOf(4, 8, 12, 16, 20))

class BingoGameMongo {
    @BsonId var id = ObjectId()
    var name: String? = null
    var cards: MutableList<BingoCardMongo> = mutableListOf()
    var type = BingoGameType.OTHER
    var freeSpace = true

    var parentCard: List<BingoSquareMongo>? = null //if it exists, all new cards use this as a template

    fun winners(): List<BingoCardMongo> {
        return cards.filter { it.isWinner() }
    }

    fun toModel(): BingoGameModel = BingoGameModel(this)
}

@Suppress("unused")
class BingoGameModel(bingoGameMongo: BingoGameMongo) {
    val id: String = bingoGameMongo.id.toString()
    val name: String? = bingoGameMongo.name
    val cards: List<BingoCardModel> = bingoGameMongo.cards.map { it.toModel() }
    val type: BingoGameType = bingoGameMongo.type
    val freeSpace: Boolean = bingoGameMongo.freeSpace
    val parentCard: List<BingoSquareModel>? = bingoGameMongo.parentCard?.map { it.toModel() }
}

class BingoCardMongo {
    @BsonId var id = ObjectId()
    var username: String? = null
    var squares: List<BingoSquareMongo>? = null
    var notes = ""

    fun isWinner(): Boolean {
        return WINNING_LINES.any { inds ->
            inds.all { i -> squares?.get(i)?.completed == true }
        }
    }

    fun toModel(): BingoCardModel = BingoCardModel(this)
}

@Suppress("unused")
class BingoCardModel(bingoCardMongo: BingoCardMongo) {
    val id: String = bingoCardMongo.id.toString()
    val username: String? = bingoCardMongo.username
    var squares: List<BingoSquareModel>? = bingoCardMongo.squares?.map { it.toModel() }
    var notes: String = bingoCardMongo.notes
}

class BingoSquareMongo {
    companion object {
        val FreeSquare = BingoSquareMongo().apply {
            completed = true
        }
    }

    @BsonId var id = ObjectId()
    var boss: Boss? = null
    var item: Drop? = null
    var task: String? = null
    var completed = false

    fun toModel(): BingoSquareModel = BingoSquareModel(this)
}

@Suppress("unused")
class BingoSquareModel(bingoSquareMongo: BingoSquareMongo) {
    val id: String = bingoSquareMongo.id.toString()
    val boss: BossModel? = bingoSquareMongo.boss?.toModel()
    val item: DropModel? = bingoSquareMongo.item?.toModel()
    val task: String? = bingoSquareMongo.task
    val completed: Boolean = bingoSquareMongo.completed
}

enum class BingoGameType { BOSSES, ITEMS, COMBINED, OTHER }

class CustomSquare {
    @JsonProperty(required = false) var boss: String? = null
    @JsonProperty(required = false) var item: String? = null
    @JsonProperty(required = false) var task: String? = null
}