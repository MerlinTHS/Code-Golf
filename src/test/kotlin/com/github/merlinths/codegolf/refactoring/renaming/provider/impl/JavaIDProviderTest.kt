package com.github.merlinths.codegolf.refactoring.renaming.provider.impl

import com.github.merlinths.codegolf.refactoring.renaming.provider.impl.java.createJavaIDProvider
import com.intellij.psi.PsiElement
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.Before
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class JavaIDProviderTest {
    @MockK
    lateinit var psiElement: PsiElement

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `Filter single underscore`() {
        val idProvider = createJavaIDProvider()

        do {
            val id = idProvider.idFor(psiElement)
            assert(id != "_") { "Id is an underscore" }
        } while (id.length == 1)
    }
}