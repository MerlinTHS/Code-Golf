package com.github.merlinths.codegolf.refactoring.rename.provider

import com.intellij.psi.PsiElement

class SetBasedNameProvider(
    initialNames: Set<String>
) : NameProvider {
    private var names = initialNames
    private var iterator = names.iterator()

    override fun nameFor(element: PsiElement): String {
        if (!iterator.hasNext()) {
            prepareNextIteration()
        }

        return iterator.next()
    }

    private fun prepareNextIteration() {
        names = names
            .map { it + it.first() }
            .toSet()

        iterator = names.iterator()
    }
}