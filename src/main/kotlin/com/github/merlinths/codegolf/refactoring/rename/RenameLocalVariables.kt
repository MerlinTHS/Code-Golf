package com.github.merlinths.codegolf.refactoring.rename

import com.github.merlinths.codegolf.psi.forEachLocalVariable
import com.github.merlinths.codegolf.refactoring.rename.provider.NameProvider
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

fun PsiElement.renameLocalVariables(
    project: Project,
    provider: NameProvider
) {
    forEachLocalVariable { variable ->
        variable.rename(
            newName = provider.nameFor(variable),
            project = project
        )
    }
}