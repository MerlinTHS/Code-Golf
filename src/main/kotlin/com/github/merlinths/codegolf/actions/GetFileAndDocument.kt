package com.github.merlinths.codegolf.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

fun AnActionEvent.getFileAndDocument(): FileAndDocument? {
    val project: Project = getData(CommonDataKeys.PROJECT) ?: return null
    val file: PsiFile = getData(CommonDataKeys.PSI_FILE) ?: return null
    val document: Document = file.getDocument(project) ?: return null

    return FileAndDocument(file, document)
}