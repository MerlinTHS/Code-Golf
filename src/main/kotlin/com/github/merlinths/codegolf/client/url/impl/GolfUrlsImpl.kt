package com.github.merlinths.codegolf.client.url.impl

import com.github.merlinths.codegolf.client.url.GolfUrls
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language

class GolfUrlsImpl : GolfUrls {
    override val base = "https://code.golf"
    override val solution = "$base/solution"

    /**
     * Builds an url for a [hole] implemented in [language] based on the [base url][base].
     */
    override fun of(hole: Hole, language: Language) =
            buildUrl(
                    hole = hole.name,
                    language = language.name.lowercase()
            )

    private fun buildUrl(
            hole: String,
            language: String
    ) = "$base/$hole#$language"
}