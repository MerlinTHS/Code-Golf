package com.github.merlinths.codegolf.actions

import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiFile

data class FileAndDocument(
    val file: PsiFile,
    val document: Document
)