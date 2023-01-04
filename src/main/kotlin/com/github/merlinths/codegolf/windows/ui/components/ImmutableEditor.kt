package com.github.merlinths.codegolf.windows.ui.components

import com.github.merlinths.codegolf.service.GolfService
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.Panel

/**
 * Immutable code editor
 */
fun Panel.immutableEditor(
        project: Project
) = panel {
    val golfService = project.getService(GolfService::class.java)

    val editor = PsiAwareTextEditorProvider.getInstance()
            .getTextEditor(golfService.minifiedEditor)

     row {
         cell(editor.component)
     }
}