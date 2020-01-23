package com.petscape.server.models

class BingoGame {
    var name: String? = null
    var cards: List<BingoCard> = emptyList()
    var type = BingoGameType.OTHER
    var freeSpace = true

    var parentCard: List<BingoSquare>? = null //if it exists, all new cards use this as a template
}

class BingoCard {
    var username: String? = null
    var squares: List<BingoSquare>? = null
}

class BingoSquare {
    companion object {
        val FreeSquare = BingoSquare().apply {
            completed = true
        }
    }

    var boss: LiteBoss? = null
    var item: Drop? = null
    var task: String? = null
    var completed = false
}

enum class BingoGameType { BOSSES, ITEMS, COMBINED, OTHER }