package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.mongojack.ObjectId
import java.util.*

class BingoGame {
    @JsonProperty("id") @ObjectId var _id = UUID.randomUUID().toString()
    var name: String? = null
    var cards: MutableList<BingoCard> = mutableListOf()
    var type = BingoGameType.OTHER
    var freeSpace = true

    var parentCard: List<BingoSquare>? = null //if it exists, all new cards use this as a template
}

class BingoCard {
    @JsonProperty("id") @ObjectId var _id = UUID.randomUUID().toString()
    var username: String? = null
    var squares: List<BingoSquare>? = null
}

class BingoSquare {
    companion object {
        val FreeSquare = BingoSquare().apply {
            completed = true
        }
    }

    @JsonProperty("id") @ObjectId var _id = UUID.randomUUID().toString()
    var boss: LiteBoss? = null
    var item: Drop? = null
    var task: String? = null
    var completed = false
}

enum class BingoGameType { BOSSES, ITEMS, COMBINED, OTHER }