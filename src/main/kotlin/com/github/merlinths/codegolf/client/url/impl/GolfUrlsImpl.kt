package com.github.merlinths.codegolf.client.url.impl

import com.github.merlinths.codegolf.client.url.GolfUrls
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import com.github.merlinths.codegolf.model.ranking.RankingPerspective
import com.github.merlinths.codegolf.model.ranking.RankingType

class GolfUrlsImpl : GolfUrls {
    override val base = "https://code.golf"
    override val solution = "$base/solution"

    /**
     * Builds an url for a ranking
     */
    override fun ofRanking(
            hole: Hole,
            language: Language,
            type: RankingType,
            perspective: RankingPerspective
    ) = buildRankingUrl(
                    hole = hole.name,
                    language = language.name.lowercase(),
                    type = type.name.lowercase(),
                    perspective = perspective.name.lowercase()
            )

    /**
     * Builds an url for a [hole] implemented in [language]..
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

    private fun buildRankingUrl(
            hole: String,
            language: String,
            type: String,
            perspective: String
    ) = "$base/api/mini-rankings/$hole/$language/$type/$perspective"
}