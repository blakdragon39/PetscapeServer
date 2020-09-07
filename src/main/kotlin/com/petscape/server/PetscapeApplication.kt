package com.petscape.server

import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import com.petscape.server.bingo.api.*
import com.petscape.server.auth.PetscapeAuthenticator
import com.petscape.server.auth.PetscapeAuthorizer
import com.petscape.server.auth.User
import com.petscape.server.health.HealthCheckResource
import com.petscape.server.health.ResourcesHealthCheck
import com.petscape.server.leaderboard.api.AddSubmissionResource
import com.petscape.server.leaderboard.api.GetLeaderboardGameResource
import com.petscape.server.leaderboard.api.GetLeaderboardGamesResource
import com.petscape.server.leaderboard.api.NewLeaderboardGameResource
import io.dropwizard.Application
import io.dropwizard.auth.AuthDynamicFeature
import io.dropwizard.auth.basic.BasicCredentialAuthFilter
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import org.slf4j.Logger
import org.slf4j.LoggerFactory


const val DB_PETSCAPE = "petscape_db"
const val COLLECTION_BINGO_GAMES = "bingo_games"
const val COLLECTION_LEADERBOARD_GAMES = "leaderboard_games"

@Throws(Exception::class)
fun main(args: Array<String>) {
    PetscapeApplication().run(*args)
}

class PetscapeApplication : Application<PetscapeConfiguration>() {

    private lateinit var logger: Logger
    private lateinit var database: MongoDatabase

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
        database = mongoClient.getDatabase(DB_PETSCAPE).withCodecRegistry(pojoCodecRegistry)
    }

    override fun run(configuration: PetscapeConfiguration, environment: Environment) {
        val auth = BasicCredentialAuthFilter.Builder<User>()
            .setAuthenticator(PetscapeAuthenticator(database, configuration))
            .setAuthorizer(PetscapeAuthorizer())
            .setRealm("Authentication")
            .buildAuthFilter()

        environment.healthChecks().register("resources", ResourcesHealthCheck())

        environment.jersey().register(AuthDynamicFeature(auth))
        environment.jersey().register(HealthCheckResource(environment.healthChecks()))

        //Bingo Resources
        /*
        TODO change username?
         */
        environment.jersey().register(ListAllBingoGamesResource(database))
        environment.jersey().register(ListAllBingoPlayersResource(database))
        environment.jersey().register(NewBingoGameResource(database))
        environment.jersey().register(NewCustomBingoGameResource(database))
        environment.jersey().register(AddBingoCardResource(database))
        environment.jersey().register(CompleteSquareResource(database))
        environment.jersey().register(UpdateNotesResource(database))
        environment.jersey().register(GetWinnersResource(database))
        environment.jersey().register(GetCardResource(database))
        environment.jersey().register(GetCardImageResource(database))

        //Leaderboard Resources
        /*
        TODO change user name?
         */
        environment.jersey().register(GetLeaderboardGamesResource(database))
        environment.jersey().register(GetLeaderboardGameResource(database))
        environment.jersey().register(NewLeaderboardGameResource(database))
        environment.jersey().register(AddSubmissionResource(database))
    }
}