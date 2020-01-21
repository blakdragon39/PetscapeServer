package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Boss(
    val name: String,
    val wilderness: Boolean,
    @JsonProperty(value = "slayer_level") val slayerLevel: Int,
    val drops: List<Drop>
)