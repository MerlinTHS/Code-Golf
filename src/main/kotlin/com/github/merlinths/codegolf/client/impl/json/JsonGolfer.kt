package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonGolfer(
        @SerialName("id")
        val id: Long,

        @SerialName("name")
        val name: String
)