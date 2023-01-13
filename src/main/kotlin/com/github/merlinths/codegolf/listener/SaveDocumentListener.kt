package com.github.merlinths.codegolf.listener

import com.github.merlinths.codegolf.service.GolfService
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
        val golfService = project.getService(GolfService::class.java)
        val language = PsiDocumentManager.getInstance(project).getPsiFile(document)?.language
            ?: return

        golfService
            .golfEditor
            .setCode(document.text)

        thisLogger().info("Saved documents language is $language")
    }
}