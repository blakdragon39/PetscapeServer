package com.petscape.server.models

class BingoGame {
    var name: String? = null
    var cards: List<BingoCard> = emptyList()
    var type = BingoGameType.OTHER

    var parentCard: BingoCard? = null //if it exists, all new cards used this as a template
}

class BingoCard {
    var username: String? = null
    var squares: List<BingoSquare>? = null
}

class BingoSquare {
    var task: Any? = null //Boss, Drop, or String
    var completed = false
}

enum class BingoGameType { BOSSES, ITEMS, OTHER }