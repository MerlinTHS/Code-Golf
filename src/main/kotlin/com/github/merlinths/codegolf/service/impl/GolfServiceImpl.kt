package com.github.merlinths.codegolf.service.impl

import com.github.merlinths.codegolf.client.impl.KtorGolfClient
import com.github.merlinths.codegolf.client.url.impl.GolfUrlsImpl
import com.github.merlinths.codegolf.service.GolfService
import com.intellij.openapi.Disposable
import com.intellij.openapi.editor.Editor

class GolfServiceImpl : GolfService, Disposable {
    private val httpClient = configureHttpClient()
    private val golfUrls = GolfUrlsImpl()

    override val client = KtorGolfClient(httpClient, golfUrls)
    override val minifiedEditor: Editor = configureMinifiedEditor("Hello World!")

    override fun dispose() {
        httpClient.close()
    }
}