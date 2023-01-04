package com.github.merlinths.codegolf.windows

import com.github.merlinths.codegolf.MyBundle
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import com.github.merlinths.codegolf.model.Solution
import com.github.merlinths.codegolf.service.GolfService
import com.github.merlinths.codegolf.threading.executeWriteAction
import com.github.merlinths.codegolf.windows.ui.tabs.playground.playground
import com.github.merlinths.codegolf.windows.ui.tabs.web.embeddedWebsite
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.service
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import kotlinx.coroutines.runBlocking

private val LOG = logger<CodeGolfWindowFactory>()

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
            addContent(factory.createPlayground(project))
            addContent(factory.createWebsite())
        }
    }

    private fun ContentFactory.createWebsite() =
            createContent(
                    embeddedWebsite("https://code.golf/solution"),
                    MyBundle.message("website"),
                    false
            )

    private fun ContentFactory.createPlayground(
            project: Project
    ) = createContent(
            playground(
                    project,
                    onSubmitSolution = {
                        submitSolution(
                                golfService = project.getService(GolfService::class.java),
                                solution = Solution(
                                        code = """interface z{static void main(String[]a){for(var b:a)for(char p=0,h=0,s=0,l=0,n=91,i=0,c,m[]=new char[n],y[]=b.toCharArray();i<y.length;c=y[i++],h=s>0?s+=c==n?1:c>n?-1:0:c<44?++m[p]:c<46?--m[p]:c==60?--p:c==62?++p:c>n?m[p]!=0?i=m[n-l]:--l:c==n?m[p]!=0?m[n-++l]=i:++s:h,System.out.print(c==46?m[p]:""));}}""",
                                        language = Language.Java
                                ),
                                hole = Hole(name = "brainfuck", "Wonderful world!")
                        )
                    }
            ),
            MyBundle.message("playground"),
            false
    )

    private fun submitSolution(
            golfService: GolfService,
            solution: Solution,
            hole: Hole
    ) {
        runBlocking {
            val result = golfService
                    .client
                    .postSolution(hole, solution)

            val message = if(result.successful) "Successful!" else "Failed!"
            Messages.showInfoMessage(message, "CodeGolf result")
        }
    }
}