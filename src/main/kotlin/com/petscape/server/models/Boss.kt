package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonProperty

class Boss {
    lateinit var name: String
    lateinit var file: String
    var wilderness = false
    @JsonProperty(value = "slayer_level") var slayerLevel = 0
    lateinit var drops: List<Drop>
}