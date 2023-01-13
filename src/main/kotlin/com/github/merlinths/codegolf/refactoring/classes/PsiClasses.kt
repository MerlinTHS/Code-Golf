package com.github.merlinths.codegolf.refactoring.classes

import com.intellij.psi.JavaRecursiveElementVisitor
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement

val PsiElement.classes: List<PsiClass>
    get() = buildList {
        accept(
            object : JavaRecursiveElementVisitor() {
                override fun visitClass(aClass: PsiClass) {
                    super.visitClass(aClass)

                    add(aClass)
                }
            }
        )
    }