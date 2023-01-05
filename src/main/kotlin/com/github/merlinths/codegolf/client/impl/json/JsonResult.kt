package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonResult(
        @SerialName("Exp")
        val expected: String,

        @SerialName("Out")
        val actual: String,

        @SerialName("Pass")
        val successful: Boolean,

        @SerialName("Argv")
        val arguments: List<String>
)