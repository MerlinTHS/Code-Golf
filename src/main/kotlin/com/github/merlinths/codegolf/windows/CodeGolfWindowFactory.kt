package com.github.merlinths.codegolf.windows

import com.github.merlinths.codegolf.MyBundle
import com.github.merlinths.codegolf.windows.ui.tabs.playground.playground
import com.github.merlinths.codegolf.windows.ui.tabs.web.embeddedWebsite
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;

private const val CODE_GOLF_URL = "https://code.golf/"
private const val SAMPLE_CODE = "interface x{public static void main(String[]a){}}"

class CodeGolfWindowFactory : ToolWindowFactory {

    /**
     * Creates the CodeGolf tool window.
     *
     * It includes the following tabs:
     *  * [playground]
     * @param[project] Current project
     * @param[window] Current tool window
     *
     * @see [playground]
     */
    override fun createToolWindowContent(
            project: Project,
            window: ToolWindow
    ) {
        val factory = ContentFactory.SERVICE.getInstance()

        with(window.contentManager) {
            addContent(factory.createPlayground(SAMPLE_CODE))
            addContent(factory.createCodeGolf())
        }
    }

    private fun ContentFactory.createCodeGolf() =
            createContent(
                    embeddedWebsite(CODE_GOLF_URL),
                    MyBundle.message("title"),
                    false
            )

    private fun ContentFactory.createPlayground(
            code: String
    ) = createContent(
            playground(code),
            MyBundle.message("playground"),
            false
    )
}