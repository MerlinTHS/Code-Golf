package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonSolution(
        @SerialName("Code")
        val code: String,

        @SerialName("Hole")
        val hole: String,

        @SerialName("Lang")
        val lang: String
)