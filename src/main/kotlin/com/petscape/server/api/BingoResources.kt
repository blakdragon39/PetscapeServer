package com.petscape.server.api

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BOSSES
import com.petscape.server.models.Boss
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/bosses")
@Produces(MediaType.APPLICATION_JSON)
class BossResource(private val db: MongoDatabase) {

    @GET
    fun getBosses(): BossResponse {
        val bosses = db.getCollection(COLLECTION_BOSSES, Boss::class.java)
        return BossResponse(bosses.toList())
    }
}

class BossResponse(val bosses: List<Boss>) {

}

fun <T> MongoCollection<T>.toList(): List<T> {
    val list = mutableListOf<T>()
    find().forEach { list.add(it) }
    return list
}