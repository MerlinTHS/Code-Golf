package com.github.merlinths.codegolf.refactoring.rename

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.refactoring.RefactoringFactory

fun PsiElement.rename(
    newName: String,
    project: Project
) {
    RefactoringFactory
        .getInstance(project)
        .createRename(this, newName)
        .run()
}