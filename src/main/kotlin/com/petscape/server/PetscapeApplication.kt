package com.petscape.server

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

@Throws(Exception::class)
fun main(args: Array<String>) {
    PetscapeApplication().run(*args)
}

class PetscapeApplication : Application<PetscapeConfiguration>() {

    override fun getName(): String {
        return "petscape-server"
    }

    override fun initialize(bootstrap: Bootstrap<PetscapeConfiguration?>) { // nothing to do yet
    }

    override fun run(configuration: PetscapeConfiguration, environment: Environment) {
        environment.jersey().register(HelloWorldResource(configuration.template, configuration.defaultName))
    }
}