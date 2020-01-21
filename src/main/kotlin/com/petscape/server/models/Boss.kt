package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Boss(
    @JsonProperty val name: String,
    @JsonProperty val wilderness: Boolean,
    @JsonProperty(value = "slayer_level") val slayerLevel: Int,
    @JsonProperty val drops: List<Drop>
)