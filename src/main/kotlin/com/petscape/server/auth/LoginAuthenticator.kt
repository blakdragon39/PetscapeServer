package com.petscape.server.auth

import com.mongodb.client.MongoDatabase
import com.petscape.server.COLLECTION_USERS
import com.petscape.server.models.User
import io.dropwizard.auth.Authenticator
import io.dropwizard.auth.basic.BasicCredentials
import java.util.*

class LoginAuthenticator(val db: MongoDatabase) : Authenticator<BasicCredentials, User> {

    override fun authenticate(credentials: BasicCredentials?): Optional<User> {
        return Optional.empty() //todo
    }
}