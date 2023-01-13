package com.github.merlinths.codegolf.service.impl

import com.github.merlinths.codegolf.actions.getDocument
import com.github.merlinths.codegolf.minify.minify
import com.github.merlinths.codegolf.refactoring.refactorIDs
import com.github.merlinths.codegolf.refactoring.renaming.provider.impl.java.createJavaIDProvider
import com.github.merlinths.codegolf.service.GolfEditor
import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.intellij.ui.jcef.JBCefBrowser
import com.intellij.util.SlowOperations

class OnlineGolfEditor(
    private val project: Project,
    private val browser: JBCefBrowser
) : GolfEditor {
    private val application = ApplicationManager.getApplication()

    override val component =  browser.component

    override fun setCode(code: String) {
        application.invokeLater {
            SlowOperations.allowSlowOperations<Exception> {
                removeLanguagePicker() // TODO: Move into listener

                val refactoredCode = refactor(code)
                injectIntoEditor(refactoredCode.minify())
            }
        }
    }

    private fun refactor(code: String): String {
        val psiFile = createPsiFile(code)
        refactorIDs(psiFile, provider = createJavaIDProvider())

        return psiFile.getDocument(project)?.text
            ?: ""
    }

    private fun removeLanguagePicker() {
        val removeCommand = """
            if(document.getElementById('picker')) {
                document.getElementById('picker').remove();
            }
        """.trimMargin()

        executeJavaScript(removeCommand)
    }

    private fun injectIntoEditor(code: String) {
        val escapedCode = code.escape()
        val injectionCommand = """
                            document.getElementById('editor')
                            .getElementsByClassName('cm-content')[0]
                            .textContent = `$escapedCode`;
                        """.trimMargin()

        executeJavaScript(injectionCommand)
    }

    private fun executeJavaScript(code: String) =
        with(browser.cefBrowser) {
            executeJavaScript(code, url, 0)
        }

    private fun createPsiFile(code: String) =
        PsiFileFactory
            .getInstance(project)
            .createFileFromText(JavaLanguage.INSTANCE, code)
}