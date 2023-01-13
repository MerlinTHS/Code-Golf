package com.github.merlinths.codegolf.actions

import com.github.merlinths.codegolf.notification.CodeGolfNotifier
import com.github.merlinths.codegolf.refactoring.minifySpace
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.psi.PsiFile

class MinifySpaceAction : DumbAwareAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val (file, document) = event.getFileAndDocument() ?: return

        minifySpace(document, file.project)

        CodeGolfNotifier.info(file.project, content = "Minified space of ${file.name}.")
    }

    override fun update(e: AnActionEvent) {
        // TODO
    }

    private fun notifyUser(file: PsiFile) {
        CodeGolfNotifier
            .info(file.project, content = "Minified space of ${file.name}.")
    }
}