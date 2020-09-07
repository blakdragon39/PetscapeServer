package com.petscape.server.leaderboard.models

import com.petscape.server.models.Boss
import com.petscape.server.models.Drop
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

class LeaderboardGameMongo {
    @BsonId var id = ObjectId()
    var title: String = ""
    var points: List<LeaderboardPointsMongo> = emptyList()
    var submissions: List<LeaderboardSubmissionMongo> = emptyList()
}

class LeaderboardGameModel(leaderboardGameMongo: LeaderboardGameMongo) {
    val id: String = leaderboardGameMongo.id.toString()
    val title: String = leaderboardGameMongo.title
    val points: List<LeaderboardPointsModel> = leaderboardGameMongo.points.map { it.toModel() }
    val submissions: List<LeaderboardSubmissionModel> = leaderboardGameMongo.submissions.map { it.toModel() }
}

class LeaderboardPointsMongo {
    var boss: Boss? = null
    var drop: Drop? = null
    var points: Int = 0

    fun toModel(): LeaderboardPointsModel = LeaderboardPointsModel(this)
}

class LeaderboardPointsModel(leaderboardPointsMongo: LeaderboardPointsMongo) {
    val boss: Boss? = leaderboardPointsMongo.boss
    val drop: Drop? = leaderboardPointsMongo.drop
    val points: Int = leaderboardPointsMongo.points
}

class LeaderboardSubmissionMongo {
    var username: String = ""
    var proof: String = ""
    var time: Long = System.currentTimeMillis()

    fun toModel(): LeaderboardSubmissionModel = LeaderboardSubmissionModel(this)
}

class LeaderboardSubmissionModel(leaderboardSubmissionMongo: LeaderboardSubmissionMongo) {
    val username: String = leaderboardSubmissionMongo.username
    val proof: String = leaderboardSubmissionMongo.proof
    val time = leaderboardSubmissionMongo.time
}