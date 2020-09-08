package com.petscape.server.bingo.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BINGO_GAMES
import com.petscape.server.bingo.models.BingoGameMongo
import com.petscape.server.bingo.getBingoGame
import com.petscape.server.models.GameId
import org.bson.types.ObjectId
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotNull
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/bingo/all")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class ListAllBingoGamesResource(private val db: MongoDatabase) {

    @GET
    fun listAllGames(): List<GameId> {
        val games = db.getCollection(COLLECTION_BINGO_GAMES, BingoGameMongo::class.java)
        return games.find().toList()
                .map { GameId(it.id.toString(), it.name ?: it.id.toString()) }
    }
}

@Path("/bingo/players")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class ListAllBingoPlayersResource(private val db: MongoDatabase) {

    @GET
    fun listAllPlayers(@QueryParam("game_id") @NotNull gameId: ObjectId): List<String?> {
        val game = getBingoGame(db, gameId)
        return game.cards.map { it.username }
    }
}