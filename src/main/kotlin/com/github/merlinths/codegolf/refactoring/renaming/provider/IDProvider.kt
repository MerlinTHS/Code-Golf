package com.github.merlinths.codegolf.refactoring.renaming.provider

import com.intellij.psi.PsiElement

fun interface IDProvider {
    fun idFor(element: PsiElement): String

    companion object
}