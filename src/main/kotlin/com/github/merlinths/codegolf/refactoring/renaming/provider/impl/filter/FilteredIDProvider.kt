package com.github.merlinths.codegolf.refactoring.renaming.provider.impl.filter

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.intellij.psi.PsiElement

/**
 * [IDProvider] which delegates ids from [provider]
 * only if [filter] returns true for them.
 */
class FilteredIDProvider(
    private val provider: IDProvider,
    private val filter: IDFilter
) : IDProvider {
    override fun idFor(element: PsiElement): String {
        var id: String

        do {
            id = provider.idFor(element)
        } while (!filter.test(id))

        return id
    }
}