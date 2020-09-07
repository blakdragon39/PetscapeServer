package com.petscape.server.leaderboard

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_LEADERBOARD_GAMES
import com.petscape.server.leaderboard.models.LeaderboardGameMongo
import org.bson.types.ObjectId
import org.litote.kmongo.findOneById
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response

fun getLeaderboardGame(db: MongoDatabase, gameId: ObjectId): LeaderboardGameMongo {
    val games = db.getCollection(COLLECTION_LEADERBOARD_GAMES, LeaderboardGameMongo::class.java)
    return games.findOneById(gameId) ?: throw WebApplicationException("Game not found", Response.Status.NOT_FOUND)
}