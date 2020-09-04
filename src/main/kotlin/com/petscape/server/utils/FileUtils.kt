package com.petscape.server.utils

import com.petscape.server.models.Boss
import com.petscape.server.models.Drop
import java.io.File
import java.io.InputStream
import java.nio.file.Paths

//val s: String = File.separator
const val s = "/"

object FileUtils {

    fun loadBoss(boss: Boss): InputStream {
        return load("bosses$s${boss.file}")
    }

    fun loadDrop(drop: Drop): InputStream {
        return load("items$s${drop.file}")
    }

    private fun load(name: String): InputStream {
        return try {
            javaClass.classLoader.getResourceAsStream(name)!!
        } catch (e: Exception) {
            val f = goUp(File(javaClass.getResource(s).path))

            Paths.get(f.path, "src${s}main${s}resources${s}", name).toUri().toURL().openStream()
        }
    }

    private fun goUp(file: File): File {
        if (file.isDirectory && file.listFiles().any { it.name == "src" }) {
            return file
        }

        return goUp(file.parentFile)
    }
}