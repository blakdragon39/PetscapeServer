package com.petscape.server.leaderboard.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_LEADERBOARD_GAMES
import com.petscape.server.leaderboard.models.LeaderboardGameModel
import com.petscape.server.leaderboard.models.LeaderboardGameMongo
import com.petscape.server.leaderboard.models.LeaderboardPointsMongo
import com.petscape.server.models.Boss
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/leaderboard/new_game")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class NewLeaderboardGameResource(val db: MongoDatabase) {

    @POST
    fun createLeaderboardGame(
        @QueryParam("name") @NotEmpty name: String,
        @NotNull points: List<LeaderboardPoints>
    ): LeaderboardGameModel {
        val game = LeaderboardGameMongo()
        game.name = name
        game.points = points.map { it.toMongo() }

        db.getCollection(COLLECTION_LEADERBOARD_GAMES, LeaderboardGameMongo::class.java).insertOne(game)
        return game.toModel()
    }
}

class LeaderboardPoints {
    var boss: String? = null
    var item: String? = null
    var points: Int? = null

    fun toMongo(): LeaderboardPointsMongo {
        val mongo = LeaderboardPointsMongo()
        mongo.boss = Boss.values().firstOrNull { it.displayName == boss } ?: throw WebApplicationException("Boss $boss not found", Response.Status.NOT_FOUND)
        mongo.drop = mongo.boss?.drops?.firstOrNull { it.first.item == item }?.first  ?: throw WebApplicationException("Item $item not found", Response.Status.NOT_FOUND)
        mongo.points = points ?: throw WebApplicationException("Points are required for $boss $item", Response.Status.BAD_REQUEST)
        return mongo
    }
}