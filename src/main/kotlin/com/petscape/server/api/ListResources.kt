package com.petscape.server.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.models.BingoGame
import javax.annotation.security.PermitAll
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/bingo/all")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class ListAllGamesResource(private val db: MongoDatabase) {

    @GET
    fun listAllGames(): List<BingoGameLite> {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGame::class.java)
        return games.find().toList()
                .map { BingoGameLite(it.id.toString(), it.name ?: it.id.toString()) }
    }
}

class BingoGameLite(val id: String, val name: String)