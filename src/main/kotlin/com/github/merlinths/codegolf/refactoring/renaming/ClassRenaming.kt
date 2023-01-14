package com.github.merlinths.codegolf.refactoring.renaming

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.github.merlinths.codegolf.refactoring.renaming.rename
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

fun PsiElement.renameClassDeclarations(
    provider: IDProvider
) {
    PsiTreeUtil
        .findChildrenOfType(this, PsiClass::class.java)
        .forEach { clazz ->
            clazz.rename(
                newName = provider.idFor(clazz)
            )
        }
}