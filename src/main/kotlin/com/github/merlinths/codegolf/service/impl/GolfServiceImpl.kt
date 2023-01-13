package com.github.merlinths.codegolf.service.impl


import com.github.merlinths.codegolf.service.impl.js.addLocationChangeListener
import com.github.merlinths.codegolf.client.impl.KtorGolfClient
import com.github.merlinths.codegolf.client.url.impl.GolfUrlsImpl
import com.github.merlinths.codegolf.service.GolfService
import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import com.intellij.ui.jcef.JBCefBrowser
import io.ktor.client.engine.cio.*

class GolfServiceImpl(
    project: Project
) : GolfService, Disposable {
    private val golfUrls = GolfUrlsImpl()
    private val httpEngine = CIO.create()
    private val browser = JBCefBrowser(golfUrls.base).apply {
        addLocationChangeListener("")
    }

    override val client = KtorGolfClient(httpEngine, golfUrls)

    override val golfEditor = OnlineGolfEditor(project, browser)

    override fun dispose() {
        httpEngine.close()
        browser.dispose()
    }
}