package com.petscape.server.leaderboard.api

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_LEADERBOARD_GAMES
import com.petscape.server.leaderboard.getLeaderboardGame
import com.petscape.server.leaderboard.models.LeaderboardGameModel
import com.petscape.server.leaderboard.models.LeaderboardGameMongo
import com.petscape.server.leaderboard.models.LeaderboardSubmissionMongo
import com.petscape.server.models.Boss
import com.petscape.server.models.Drop
import org.bson.types.ObjectId
import org.litote.kmongo.updateOneById
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/leaderboard/add_submission")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class AddSubmissionResource(val db: MongoDatabase) {

    @POST
    fun addSubmission(
        @QueryParam("game_id") @NotNull gameId: ObjectId,
        @QueryParam("username") @NotEmpty username: String,
        @QueryParam("boss") @NotEmpty boss: String,
        @QueryParam("item") @NotEmpty item: String,
        @QueryParam("proof") @NotEmpty proof: String
    ): LeaderboardGameModel {
        val games = db.getCollection(COLLECTION_LEADERBOARD_GAMES, LeaderboardGameMongo::class.java)
        val game = getLeaderboardGame(db, gameId)

        val submission = LeaderboardSubmissionMongo()
        submission.username = username
        //todo validate that boss/item are in game??
        submission.boss = Boss.values().firstOrNull { it.displayName == boss } ?: throw WebApplicationException("Boss $boss not found", Response.Status.NOT_FOUND)
        submission.drop = Drop.values().firstOrNull { it.item == item } ?: throw WebApplicationException("Item $item not found", Response.Status.NOT_FOUND)
        submission.proof = proof

        game.submissions.add(submission)
        games.updateOneById(gameId, game)

        return game.toModel()
    }
}