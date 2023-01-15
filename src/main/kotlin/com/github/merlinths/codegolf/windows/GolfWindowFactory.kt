package com.github.merlinths.codegolf.windows

import com.github.merlinths.codegolf.windows.tabs.OnlineTab
import com.github.merlinths.codegolf.windows.tabs.Tab
import com.github.merlinths.codegolf.windows.tabs.PlaygroundTab
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import javax.swing.JComponent


class GolfWindowFactory : ToolWindowFactory {
    /**
     * Creates the CodeGolf tool window.
     *
     * Contains an [online][OnlineTab] and a [playground][PlaygroundTab] tab.
     *
     * @param[project] Current project
     * @param[window] Current tool window
     *
     */
    override fun createToolWindowContent(
        project: Project,
        window: ToolWindow
    ) {
        val tabs = listOf(
            OnlineTab(project),
            PlaygroundTab()
        )

        tabs.map(Tab::toContent)
            .forEach(window.contentManager::addContent)
    }
}