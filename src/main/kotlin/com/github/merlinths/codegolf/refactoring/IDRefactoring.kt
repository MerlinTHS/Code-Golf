package com.github.merlinths.codegolf.refactoring

import com.github.merlinths.codegolf.refactoring.classes.renameClassDeclarations
import com.github.merlinths.codegolf.refactoring.methods.renameMethodDeclarations
import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.github.merlinths.codegolf.refactoring.variables.renameLocalVariables
import com.intellij.psi.PsiFile

fun refactorIDs(
    psiFile: PsiFile,
    provider: IDProvider
) {
    with(psiFile) {
        renameClassDeclarations(provider)
        renameMethodDeclarations(provider)
        renameLocalVariables(provider)
    }
}