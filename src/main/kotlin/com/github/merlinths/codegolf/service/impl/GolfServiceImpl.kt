package com.github.merlinths.codegolf.service.impl

import com.github.merlinths.codegolf.client.impl.KtorGolfClient
import com.github.merlinths.codegolf.client.url.impl.GolfUrlsImpl
import com.github.merlinths.codegolf.service.GolfService
import com.intellij.openapi.Disposable
import com.intellij.openapi.editor.Editor
import io.ktor.client.engine.cio.*

class GolfServiceImpl : GolfService, Disposable {
    private val httpEngine = CIO.create()
    private val golfUrls = GolfUrlsImpl()

    override val client = KtorGolfClient(httpEngine, golfUrls)
    override val minifiedEditor: Editor = configureMinifiedEditor("Hello World!")

    override fun dispose() {
        httpEngine.close()
    }
}