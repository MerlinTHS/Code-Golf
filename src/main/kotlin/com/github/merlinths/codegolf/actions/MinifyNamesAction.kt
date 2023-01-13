package com.github.merlinths.codegolf.actions

import com.github.merlinths.codegolf.notification.CodeGolfNotifier
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class MinifyNamesAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val (file) = event.getFileAndDocument() ?: return

        //minifyNames(file, provider = SetBasedNameProvider(characterSet))
        notifyUser(file)
    }

    override fun update(event: AnActionEvent) {
        val editor: Editor? = event.getData(CommonDataKeys.EDITOR)
        val psiFile: PsiFile? = event.getData(CommonDataKeys.PSI_FILE)

        event.presentation.isEnabled =
            (editor != null) && (psiFile != null)
    }

    private fun notifyUser(file: PsiFile) {
        CodeGolfNotifier
            .info(file.project, content = "Minified names of ${file.name}.")
    }
}