package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.types.ObjectId
import org.omg.CORBA.Object
import java.util.*

class BingoGame {
    @JsonProperty("id") var _id = ObjectId()
    var name: String? = null
    var cards: MutableList<BingoCard> = mutableListOf()
    var type = BingoGameType.OTHER
    var freeSpace = true

    var parentCard: List<BingoSquare>? = null //if it exists, all new cards use this as a template
}

class BingoCard {
    @JsonProperty("id") var _id = ObjectId()
    var username: String? = null
    var squares: List<BingoSquare>? = null
}

class BingoSquare {
    companion object {
        val FreeSquare = BingoSquare().apply {
            completed = true
        }
    }

    @JsonProperty("id") var _id = ObjectId()
    var boss: LiteBoss? = null
    var item: Drop? = null
    var task: String? = null
    var completed = false
}

enum class BingoGameType { BOSSES, ITEMS, COMBINED, OTHER }