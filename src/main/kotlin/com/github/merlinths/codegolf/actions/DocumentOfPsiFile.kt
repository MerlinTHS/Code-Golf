package com.github.merlinths.codegolf.actions

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile

fun PsiFile.getDocument(project: Project) =
    PsiDocumentManager
        .getInstance(project)
        .getDocument(this)