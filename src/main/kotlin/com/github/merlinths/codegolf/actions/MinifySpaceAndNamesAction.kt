package com.github.merlinths.codegolf.actions

import com.github.merlinths.codegolf.notification.CodeGolfNotifier
import com.github.merlinths.codegolf.refactoring.minifySpace
import com.github.merlinths.codegolf.refactoring.refactorIDs
import com.github.merlinths.codegolf.refactoring.renaming.provider.impl.java.createJavaIDProvider
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class MinifySpaceAndNamesAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val (file, document) = event.getFileAndDocument() ?: return
        val project = file.project

        refactorIDs(file, provider = createJavaIDProvider())
        minifySpace(document, project)

        CodeGolfNotifier.info(project, content = "Minified space and names of ${file.name}!")
    }

    override fun update(event: AnActionEvent) {
        // TODO
    }
}

