package com.github.merlinths.codegolf.refactoring.rename.provider

import com.intellij.psi.PsiElement

fun interface NameProvider {
    fun nameFor(element: PsiElement): String
}