package com.github.merlinths.codegolf.client.url

import com.github.merlinths.codegolf.client.url.impl.GolfUrlsImpl
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GolfUrlsImplTest {
    private lateinit var golfUrls: GolfUrls

    @Before
    fun setup() {
        golfUrls = GolfUrlsImpl()
    }

    @Test
    fun `base should be CodeGolf's home url`() {
        assertEquals("https://code.golf", golfUrls.base)
    }

    @Test
    fun `solution should be CodeGolf's solution url`() {
        assertEquals("https://code.golf/solution", golfUrls.solution)
    }

    // TODO: Use JUnit5 for parameterized tests!
    @Test
    fun `buildUrl works for 'brainfuck'`() {
        assertEquals(
                "https://code.golf/brainfuck#java",
                golfUrls.of(
                        Hole("brainfuck"),
                        Language.Java
                )
        )
    }
}