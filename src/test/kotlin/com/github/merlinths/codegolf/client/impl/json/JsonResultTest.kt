package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class JsonResultTest {
    @Test
    fun `Json encoding works`() {
        val result = JsonResult("Lua", "Lua", true, emptyList())
        val serializedResult = """{"Exp":"${result.expected}","Out":"${result.actual}","Pass":${result.successful},"Argv":[]}"""
        println(serializedResult)
        val deserializedResult = Json.decodeFromString<JsonResult>(serializedResult)
        assertEquals(result, deserializedResult)
    }

    @Test
    fun `Json decoding works`() {
        val expected = "Hello World!"
        val actual = "Hello Kotlin!"
        val successful = false
        val arguments = "[]"

        val serializedResult = """{
            | "Exp": "$expected",
            | "Out": "$actual",
            | "Pass": $successful
            | "Argv": $arguments
            |}""".trimMargin()

        val result = Json.decodeFromString<JsonResult>(serializedResult)
        println(result)

        assertEquals(expected, result.expected)
        assertEquals(actual, result.actual)
        assertEquals(successful, result.successful)
        assert(result.arguments.isEmpty())
    }
}