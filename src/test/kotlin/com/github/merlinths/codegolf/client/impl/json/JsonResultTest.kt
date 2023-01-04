package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class JsonResultTest {
    @Test
    fun `Json decoding works`() {
        val expected = "Hello world!"
        val actual = "Hello Kotlin!"
        val successful = false

        val serializedResult = """{
            | "Exp": "$expected",
            | "Out": "$actual",
            | "Pass": $successful
            |}""".trimMargin()

        val result = Json.decodeFromString<JsonResult>(serializedResult)

        assertEquals(expected, result.expected)
        assertEquals(actual, result.actual)
        assertEquals(successful, result.successful)
    }
}