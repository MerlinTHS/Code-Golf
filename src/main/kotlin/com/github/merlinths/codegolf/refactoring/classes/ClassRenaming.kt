package com.github.merlinths.codegolf.refactoring.classes

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.github.merlinths.codegolf.refactoring.renaming.rename
import com.intellij.psi.PsiElement

fun PsiElement.renameClassDeclarations(
    provider: IDProvider
) {
    classes.forEach { declaration ->
        declaration.rename(
            newName = provider.idFor(declaration)
        )
    }
}