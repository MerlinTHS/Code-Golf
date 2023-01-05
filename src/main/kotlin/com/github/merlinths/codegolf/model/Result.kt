package com.github.merlinths.codegolf.model

data class Result(
        val successful: Boolean,
        val arguments: List<String>,
        val expected: String,
        val actual: String
)