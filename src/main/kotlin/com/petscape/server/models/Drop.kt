package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Drop(
    val item: String,
    @JsonProperty(value = "drop_rate") val dropRate: Int
)