package com.petscape.server.leaderboard.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_LEADERBOARD_GAMES
import com.petscape.server.leaderboard.getLeaderboardGame
import com.petscape.server.leaderboard.models.LeaderboardGameModel
import com.petscape.server.leaderboard.models.LeaderboardGameMongo
import com.petscape.server.models.GameId
import org.bson.types.ObjectId
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotNull
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/leaderboard/all")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class GetLeaderboardGamesResource(val db: MongoDatabase) {
    @GET
    fun getAllGames(): List<GameId> {
        val games = db.getCollection(COLLECTION_LEADERBOARD_GAMES, LeaderboardGameMongo::class.java)
        return games.find().toList().map { GameId(it.id.toString(), it.name) }
    }
}

@Path("/leaderboard/get_game")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class GetLeaderboardGameResource(val db: MongoDatabase) {
    @GET
    fun getGame(@QueryParam("game_id") @NotNull gameId: ObjectId) : LeaderboardGameModel {
        return getLeaderboardGame(db, gameId).toModel()
    }
}