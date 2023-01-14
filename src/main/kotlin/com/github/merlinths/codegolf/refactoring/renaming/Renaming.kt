package com.github.merlinths.codegolf.refactoring.renaming

import com.intellij.psi.PsiElement
import com.intellij.psi.search.LocalSearchScope
import com.intellij.refactoring.RefactoringFactory

fun PsiElement.rename(
    newName: String
) {
    RefactoringFactory
        .getInstance(project)
        .createRename(this, newName, LocalSearchScope(this), false, false)
        .run()
}