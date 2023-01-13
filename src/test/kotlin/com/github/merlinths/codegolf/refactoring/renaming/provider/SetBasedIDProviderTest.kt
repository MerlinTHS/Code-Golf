package com.github.merlinths.codegolf.refactoring.renaming.provider

import com.github.merlinths.codegolf.refactoring.renaming.provider.impl.SetBasedIDProvider
import com.intellij.psi.PsiElement
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class SetBasedIDProviderTest {
    @MockK
    lateinit var psiElement: PsiElement

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Nested
    @DisplayName("Same start and common characters")
    inner class SameStartAndCommonTests {
        private val characters = ('a'..'c')

        private val idProvider =
            SetBasedIDProvider.of(
                startCharacters = characters,
                commonCharacters = characters
            )

        @Test
        fun `First iteration provides character set`() {
            idProvider.assertNextIDs(*characters.toStringArray())
        }

        @Test
        fun `Second iteration provides 9 unique names`() {
            with(idProvider) {
                // Ignore first iteration
                repeat(3) { idFor(psiElement) }

                assertNextIDs(
                    "aa", "ab", "ac",
                    "ba", "bb", "bc",
                    "ca", "cb", "cc",
                )
            }
        }

        @Test
        fun `Provides 363 variations for length 5`() {
            with(idProvider) {
                repeat(362) { idFor(psiElement) }

                assertNextID("ccccc")
            }
        }

        @Test
        fun `Provides 1092 variations for length 6`() {
            with(idProvider) {
                repeat(1091) { idFor(psiElement) }

                assertNextID("cccccc")
            }
        }
    }

    @Nested
    @DisplayName("Different start and common characters")
    inner class DifferentStartAndCommonTests {
        private val startCharacters = ('a' until 'd')
        private val commonCharacters = ('0' until '9')

        private val idProvider =
            SetBasedIDProvider.of(startCharacters, commonCharacters)

        @Test
        fun `First iteration provides startCharacters`() {
            idProvider.assertNextIDs(*startCharacters.toStringArray())
        }

        @Test
        fun `Provides 30 variations for length 2`() {
            with(idProvider) {
                repeat(29) { idFor(psiElement) }

                assertNextID("c8")
            }
        }
    }

    private fun CharRange.toStringArray() =
        map(Char::toString)
            .toTypedArray()

    private fun IDProvider.assertNextIDs(vararg expectedIdentifiers: String) {
        for (expectedIdentifier in expectedIdentifiers) {
            assertNextID(expectedIdentifier)
        }
    }

    private fun IDProvider.assertNextID(expected: String) =
        assertEquals(expected, idFor(psiElement))

    fun SetBasedIDProvider.Companion.of(
        startCharacters: CharRange,
        commonCharacters: CharRange
    ) = SetBasedIDProvider(
        startCharacters.toSet(),
        commonCharacters.toSet()
    )
}
