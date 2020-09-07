package com.petscape.server.leaderboard.api

import com.mongodb.client.MongoDatabase
import org.bson.types.ObjectId
import javax.annotation.security.PermitAll
import javax.validation.constraints.NotEmpty
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/leaderboard/add_submission")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
class AddSubmissionResource(val db: MongoDatabase) {

    @POST
    fun addSubmission(
        @QueryParam("game_id") @NotEmpty gameId: ObjectId,
        @QueryParam("username") @NotEmpty username: String,
        @QueryParam("boss") @NotEmpty boss: String,
        @QueryParam("item") @NotEmpty item: String,
        @QueryParam("proof") @NotEmpty proof: String
    ) {

    }
}