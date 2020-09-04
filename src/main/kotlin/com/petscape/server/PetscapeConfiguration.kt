package com.petscape.server

import io.dropwizard.Configuration


class PetscapeConfiguration : Configuration() {
    lateinit var username: String
    lateinit var password: String
}