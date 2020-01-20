package com.petscape.server

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import javax.validation.constraints.NotEmpty


class PetscapeConfiguration : Configuration() {
    @JsonProperty
    @NotEmpty
    lateinit var template: String

    @JsonProperty
    @NotEmpty
    var defaultName = "Stranger"
}