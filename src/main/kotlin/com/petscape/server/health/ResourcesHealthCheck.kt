package com.petscape.server.health

import com.codahale.metrics.health.HealthCheck
import com.petscape.server.models.Boss
import com.petscape.server.utils.FileUtils
import java.io.FileNotFoundException

class ResourcesHealthCheck : HealthCheck() {

    override fun check(): Result {
        for (boss in Boss.values()) {
            try {
                if (boss.file.isEmpty()) {
                    return Result.unhealthy("File not found for ${boss.name}")
                } else {
                    FileUtils.loadBoss(boss)
                }
            } catch (e: FileNotFoundException) {
                return Result.unhealthy("File not found for ${boss.name}")
            }

            for (dropPair in boss.drops) {
                val drop = dropPair.first
                try {
                    if (drop.file.isEmpty()) {
                        return Result.unhealthy("File not found for ${dropPair.first.item}")
                    } else {
                        FileUtils.loadDrop(drop)
                    }
                } catch (e: FileNotFoundException) {
                    return Result.unhealthy("File not found for ${dropPair.first.item}")
                }
            }
        }

        return Result.healthy()
    }
}