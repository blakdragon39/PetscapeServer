package com.petscape.server.health

import com.codahale.metrics.health.HealthCheck
import com.petscape.server.models.Boss
import com.petscape.server.utils.FileUtils
import java.io.FileNotFoundException

class ResourcesHealthCheck : HealthCheck() {

    override fun check(): Result {
        val bosses = Boss.values()

        for (boss in bosses) {
            try {
                FileUtils.loadBoss(boss)
            } catch (e: FileNotFoundException) {
                return Result.unhealthy("File not found for ${boss.name}")
            }

            for (dropPair in boss.drops) {
                try {
                    FileUtils.loadDrop(dropPair.first)
                } catch (e: FileNotFoundException) {
                    return Result.unhealthy("File not found for ${dropPair.first.item}")
                }
            }
        }

        return Result.healthy()
    }
}