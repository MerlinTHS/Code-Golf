package com.github.merlinths.codegolf.psi

import com.intellij.psi.JavaRecursiveElementVisitor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLocalVariable

fun PsiElement.forEachLocalVariable(action: (PsiLocalVariable) -> Unit) {
    this.accept(
        object : JavaRecursiveElementVisitor() {
            override fun visitLocalVariable(variable: PsiLocalVariable) {
                super.visitLocalVariable(variable)

                action(variable)
            }
        }
    )
}