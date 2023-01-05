package com.github.merlinths.codegolf.client.impl

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

private val jsonConfiguration = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
}

/**
 * Creates and configures [HttpClient] with
 * content negotiation for json.
 */
internal fun configureHttpClient(engine: HttpClientEngine) =
        HttpClient(engine) {
            install(ContentNegotiation) {
                json(jsonConfiguration)
            }
        }