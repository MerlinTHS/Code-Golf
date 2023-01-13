package com.github.merlinths.codegolf.refactoring.renaming.provider.impl

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.intellij.psi.PsiElement

class SetBasedIDProvider(
    startCharacters: Set<Char>,
    private val commonCharacters: Set<Char>
) : IDProvider {
    private var names =
        startCharacters
            .map(Char::toString)
            .toSet()

    private var nameIterator =
        names.iterator()

    override fun idFor(element: PsiElement): String {
        if (!nameIterator.hasNext()) {
            prepareNextIteration()
        }

        return nameIterator.next()
    }

    private fun prepareNextIteration() {
        names = names.flatMap { name ->
            commonCharacters.map { name + it }
        }.toSet()

        nameIterator = names.iterator()
    }

    /**
     * Companion object to allow extensions.
     */
    companion object
}