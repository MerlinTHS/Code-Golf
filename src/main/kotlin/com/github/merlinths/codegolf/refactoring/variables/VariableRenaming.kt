package com.github.merlinths.codegolf.refactoring.variables

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.github.merlinths.codegolf.refactoring.renaming.rename
import com.intellij.psi.PsiElement

fun PsiElement.renameLocalVariables(
    provider: IDProvider
) {
    variables.forEach { variable ->
        variable.rename(
            newName = provider.idFor(variable)
        )
    }
}