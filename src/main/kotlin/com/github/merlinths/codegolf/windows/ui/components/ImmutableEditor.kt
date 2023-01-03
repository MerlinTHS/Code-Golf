package com.github.merlinths.codegolf.windows.ui.components

import com.intellij.ui.EditorTextField
import com.intellij.ui.dsl.builder.Panel

/**
 * Immutable code editor
 */
fun Panel.immutableEditor(
        code: String
) = panel {
    row {
        cell(EditorTextField(code))
    }
}