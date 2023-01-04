package com.github.merlinths.codegolf.service

import com.github.merlinths.codegolf.client.GolfClient
import com.intellij.openapi.editor.Editor

interface GolfService {
    val client: GolfClient

    val minifiedEditor: Editor
}