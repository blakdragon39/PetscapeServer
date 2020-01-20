package com.petscape.server

import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider


@Throws(Exception::class)
fun main(args: Array<String>) {
    PetscapeApplication().run(*args)
}

class PetscapeApplication : Application<PetscapeConfiguration>() {

    lateinit var mongoClient: MongoClient

    override fun getName(): String {
        return "petscape-server"
    }

    override fun initialize(bootstrap: Bootstrap<PetscapeConfiguration?>) {
        mongoClient = MongoClients.create()
        val pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        )
    }

    override fun run(configuration: PetscapeConfiguration, environment: Environment) {
        environment.healthChecks().register()
        environment.jersey().register(HelloWorldResource(configuration.template, configuration.defaultName))
    }
}