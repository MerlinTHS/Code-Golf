package com.github.merlinths.codegolf.service.impl

import com.intellij.openapi.editor.EditorFactory

internal fun configureMinifiedEditor(text: String) =
        with(EditorFactory.getInstance()) {
            createEditor(
                    createDocument(text)
            )
        }