package com.github.merlinths.codegolf.refactoring.rename.provider

import com.intellij.psi.PsiElement
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class SetBasedNameProviderTest {
    @MockK
    lateinit var psiElement: PsiElement

    @Test
    fun `First iteration is initial set`() {
        val names = setOf("a", "b", "c")
        val provider = SetBasedNameProvider(names)

        assertEquals("a", provider.provideName())
        assertEquals("b", provider.provideName())
        assertEquals("c", provider.provideName())
    }

    @Test
    fun `Names are repeated`() {
        val names = setOf("a", "b", "c")
        val provider = SetBasedNameProvider(names)

        // Ignore first iteration
        repeat(3) { provider.provideName() }

        assertEquals("aa", provider.provideName())
        assertEquals("bb", provider.provideName())
        assertEquals("cc", provider.provideName())
    }

    private fun NameProvider.provideName() =
        nameFor(psiElement)
}