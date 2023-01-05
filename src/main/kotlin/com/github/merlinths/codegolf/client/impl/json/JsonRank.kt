package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonRank(
        @SerialName("bytes")
        val bytes: Long,

        @SerialName("chars")
        val chars: Long,

        @SerialName("golfer")
        val golfer: JsonGolfer,

        @SerialName("rank")
        val position: Int,

        @SerialName("me")
        val isMe: Boolean
)