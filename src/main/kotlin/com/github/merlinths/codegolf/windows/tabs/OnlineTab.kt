package com.github.merlinths.codegolf.windows.tabs

import com.github.merlinths.codegolf.MyBundle
import com.github.merlinths.codegolf.service.GolfService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import javax.swing.JComponent

class OnlineTab(
    project: Project
) : Tab {
    override val title = MyBundle.message("online")

    override val component = project
        .service<GolfService>()
        .golfEditor
        .component
}