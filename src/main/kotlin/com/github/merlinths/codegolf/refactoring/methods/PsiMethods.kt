package com.github.merlinths.codegolf.refactoring.methods

import com.intellij.psi.JavaRecursiveElementVisitor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod

val PsiElement.methods: List<PsiMethod>
    get() = buildList {
        accept(
            object : JavaRecursiveElementVisitor() {
                override fun visitMethod(method: PsiMethod) {
                    super.visitMethod(method)

                    add(method)
                }
            }
        )
    }