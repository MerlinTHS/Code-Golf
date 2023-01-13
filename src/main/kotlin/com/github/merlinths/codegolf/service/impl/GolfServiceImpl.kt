package com.github.merlinths.codegolf.service.impl

import com.github.merlinths.codegolf.service.GolfService
import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import com.intellij.ui.jcef.JBCefBrowser

class GolfServiceImpl(
    project: Project
) : GolfService, Disposable {
    private val browser = JBCefBrowser("https://code.golf")

    override val golfEditor = OnlineGolfEditor(project, browser)
 
    override fun dispose() {
        browser.dispose()
    }
}