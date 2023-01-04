package com.github.merlinths.codegolf.model

import kotlinx.serialization.Serializable

data class GolfResult(
        val successful: Boolean,
        val tests: List<GolfTest>,
)