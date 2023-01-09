package com.github.merlinths.codegolf.refactoring.minify

import com.github.merlinths.codegolf.minify.minify
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project

fun minifySpace(
    document: Document,
    project: Project
) {
    WriteCommandAction.runWriteCommandAction(project) {
        document.setText(
            document.text.minify()
        )
    }
}