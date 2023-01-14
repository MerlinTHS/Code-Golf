package com.github.merlinths.codegolf.listener

import com.github.merlinths.codegolf.service.GolfService
import com.intellij.ide.highlighter.JavaFileType
import com.intellij.model.ModelBranch
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileDocumentManagerListener
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager

class SaveDocumentListener(
        private val project: Project
) : FileDocumentManagerListener {
    /**
     * Copies saved code to CodeGolf editor and minifies it on the fly.
     */
    override fun beforeDocumentSaving(document: Document) {
        if (isJava(document)) {
            thisLogger().info("Save java file")
            saveMinifiedCode(document.text)
        }
    }

    private fun saveMinifiedCode(code: String) {
        val golfService = project.service<GolfService>()

        golfService
            .golfEditor
            .setCode(code)
    }

    private fun isJava(document: Document) =
        PsiDocumentManager
            .getInstance(project)
            .getPsiFile(document)
            ?.fileType == JavaFileType.INSTANCE
}