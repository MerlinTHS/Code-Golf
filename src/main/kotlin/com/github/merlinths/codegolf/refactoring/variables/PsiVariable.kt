package com.github.merlinths.codegolf.refactoring.variables

import com.intellij.psi.JavaRecursiveElementVisitor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiVariable

val PsiElement.variables: List<PsiElement>
    get() = buildList {
        accept(
            object : JavaRecursiveElementVisitor() {
                override fun visitVariable(variable: PsiVariable) {
                    super.visitVariable(variable)

                    add(variable)
                }
            }
        )
    }