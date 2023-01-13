package com.github.merlinths.codegolf.refactoring.methods

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.github.merlinths.codegolf.refactoring.renaming.rename
import com.intellij.lang.jvm.JvmModifier
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod

fun PsiElement.renameMethodDeclarations(
    provider: IDProvider
) {
    methods
        .filterNot(PsiMethod::isMainMethod)
        .forEach { method ->
            method.rename(
                newName = provider.idFor(method)
            )
        }
}

internal fun PsiMethod.isMainMethod() =
    returnType?.equalsToText("void") == true
            && hasModifier(JvmModifier.PUBLIC)
            && hasModifier(JvmModifier.STATIC)
            // && parameterList.isEquivalentTo(...)