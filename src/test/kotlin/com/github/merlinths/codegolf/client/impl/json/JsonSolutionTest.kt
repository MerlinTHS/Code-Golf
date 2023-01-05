package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JsonSolutionTest {
    @Test
    fun `Json decoding works`() {
        val code = "interface x{}"
        val hole = "brainfuck"
        val lang = "java"

        val serializedSolution = """{
            | "Code": "$code",
            | "Hole": "$hole",
            | "Lang": "$lang"
            |}""".trimMargin()

        val solution = Json.decodeFromString<JsonSolution>(serializedSolution)

        assertEquals(code, solution.code)
        assertEquals(hole, solution.hole)
        assertEquals(lang, solution.lang)
    }

    @Test
    fun `Json encoding works`() {
        val solution = JsonSolution("println()", "catalan-numbers", "kotlin")
        val serializedSolution = """{"Code":"${solution.code}","Hole":"${solution.hole}","Lang":"${solution.lang}"}"""

        val deserializedSolution = Json.decodeFromString<JsonSolution>(serializedSolution)
        assertEquals(solution, deserializedSolution)
    }
}