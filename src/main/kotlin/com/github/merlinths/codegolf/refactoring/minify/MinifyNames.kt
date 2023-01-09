package com.github.merlinths.codegolf.refactoring.minify

import com.github.merlinths.codegolf.refactoring.rename.provider.NameProvider
import com.github.merlinths.codegolf.refactoring.rename.renameLocalVariables
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

fun minifyNames(
    psiFile: PsiFile,
    provider: NameProvider,
    project: Project,
) {
    psiFile.renameLocalVariables(project, provider)

    // Rename methods
    // Rename classes
}