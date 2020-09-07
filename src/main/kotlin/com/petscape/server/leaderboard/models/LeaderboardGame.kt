package com.petscape.server.leaderboard.models

import com.petscape.server.models.Boss
import com.petscape.server.models.BossModel
import com.petscape.server.models.Drop
import com.petscape.server.models.DropModel
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

class LeaderboardGameMongo {
    @BsonId var id = ObjectId()
    var name: String = ""
    var points: List<LeaderboardPointsMongo> = emptyList()
    var submissions: List<LeaderboardSubmissionMongo> = emptyList()

    fun toModel(): LeaderboardGameModel = LeaderboardGameModel(this)
}

class LeaderboardGameModel(leaderboardGameMongo: LeaderboardGameMongo) {
    val id: String = leaderboardGameMongo.id.toString()
    val name: String = leaderboardGameMongo.name
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
    val boss: BossModel? = leaderboardPointsMongo.boss?.toModel()
    val drop: DropModel? = leaderboardPointsMongo.drop?.toModel()
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