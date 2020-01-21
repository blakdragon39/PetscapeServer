package com.petscape.server.models

import java.security.Principal

class User(val email: String? = null,
           val displayName: String? = null,
           val encryptedPassword: String? = null): Principal {

    override fun getName(): String {
        return email!!
    }
}