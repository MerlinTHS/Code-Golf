package com.github.merlinths.codegolf.refactoring.renaming

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.github.merlinths.codegolf.refactoring.renaming.rename
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiVariable
import com.intellij.psi.util.PsiTreeUtil

fun PsiElement.renameLocalVariables(
    provider: IDProvider
) {
    PsiTreeUtil
        .findChildrenOfType(this, PsiVariable::class.java)
        .forEach { variable ->
            variable.rename(
                newName = provider.idFor(variable)
            )
        }
}