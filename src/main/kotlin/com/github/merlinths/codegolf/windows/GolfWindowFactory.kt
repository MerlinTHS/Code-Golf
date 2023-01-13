package com.github.merlinths.codegolf.windows

import com.github.merlinths.codegolf.MyBundle
import com.github.merlinths.codegolf.service.GolfService
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import javax.swing.JComponent

class GolfWindowFactory : ToolWindowFactory {

    /**
     * Creates the CodeGolf tool window.
     *
     * Contains an online tab.
     *
     * @param[project] Current project
     * @param[window] Current tool window
     *
     */
    override fun createToolWindowContent(
            project: Project,
            window: ToolWindow
    ) {
        val factory = ContentFactory.SERVICE.getInstance()
        val browserComponent = getBrowserComponent(project)

        with(window.contentManager) {
            addContent(factory.createOnlineTab(browserComponent))
        }
    }

    private fun getBrowserComponent(project: Project): JComponent =
        project
            .getService(GolfService::class.java)
            .golfEditor
            .component

    private fun ContentFactory.createOnlineTab(component: JComponent) =
        createContent(
            component,
            MyBundle.message("online"),
            false
        )
}