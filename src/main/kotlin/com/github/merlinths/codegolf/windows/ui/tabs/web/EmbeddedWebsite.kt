package com.github.merlinths.codegolf.windows.ui.tabs.web

import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.jcef.JBCefBrowser

fun embeddedWebsite(
        url: String
) = panel {
    val browser = JBCefBrowser(url)

    row {
        cell(browser.component)
    }
}