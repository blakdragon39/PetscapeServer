package com.petscape.server

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.BasicDBList
import com.mongodb.BasicDBObject
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import com.mongodb.util.JSON
import com.petscape.server.models.Boss
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File


const val PETSCAPE_DB = "petscape_db"
const val BOSSES_COLLECTION = "bosses"

@Throws(Exception::class)
fun main(args: Array<String>) {
    PetscapeApplication().run(*args)
}

class PetscapeApplication : Application<PetscapeConfiguration>() {

    lateinit var logger: Logger
    lateinit var database: MongoDatabase

    override fun getName(): String {
        return "petscape-server"
    }

    override fun initialize(bootstrap: Bootstrap<PetscapeConfiguration?>) {
        logger = LoggerFactory.getLogger(javaClass.name)

        val pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        )

        val mongoClient = MongoClients.create()
        database = mongoClient.getDatabase(PETSCAPE_DB).withCodecRegistry(pojoCodecRegistry)

        seedDb()

    }

    override fun run(configuration: PetscapeConfiguration, environment: Environment) {
//        environment.healthChecks().register()
//        environment.jersey().register(Resource())
    }

    fun seedDb() {
        val bossCollection = database.getCollection(BOSSES_COLLECTION, Boss::class.java)
        val file = File(javaClass.classLoader.getResource("initial_data.json")?.file ?: "")
        val bosses = ObjectMapper().readValue(file, object : TypeReference<List<Boss>>() {})

        bossCollection.drop()
        bossCollection.insertMany(bosses)
    }
}