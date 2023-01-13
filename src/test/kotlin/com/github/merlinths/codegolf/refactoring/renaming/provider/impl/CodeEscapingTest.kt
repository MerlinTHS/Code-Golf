package com.github.merlinths.codegolf.refactoring.renaming.provider.impl

import com.github.merlinths.codegolf.service.impl.escape
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CodeEscapingTest {
    @Test
    fun `Escape dollar signs`() {
        val code = "interface " + '$' + "{public void test(){}}"

        assertEquals("interface \\\${public void test(){}}", code.escape())
    }
}