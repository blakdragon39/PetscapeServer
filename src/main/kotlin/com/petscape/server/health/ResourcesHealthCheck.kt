package com.petscape.server.health

import com.codahale.metrics.health.HealthCheck
import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_BOSSES
import com.petscape.server.models.Boss
import com.petscape.server.utils.FileUtils

class ResourcesHealthCheck(private val db: MongoDatabase) : HealthCheck() {

    override fun check(): Result {
        val bosses = db.getCollection(COLLECTION_BOSSES, Boss::class.java)

        for (boss in bosses.find()) {
            val bossFile = FileUtils.findBoss(boss)
            bossFile ?: return Result.unhealthy("File for boss ${boss.name} not found")

            for (drop in boss.drops) {
                val dropFile = FileUtils.findDrop(drop)
                dropFile ?: return Result.unhealthy("File for drop ${drop.item} not found")
            }
        }

        return Result.healthy()
    }
}