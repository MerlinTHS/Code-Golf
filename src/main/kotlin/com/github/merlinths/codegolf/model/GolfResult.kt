package com.github.merlinths.codegolf.model

data class GolfResult(
        val tests: List<GolfTest>,
        val successful: Boolean
)