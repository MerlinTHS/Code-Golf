package com.github.merlinths.codegolf.client.url

import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import com.github.merlinths.codegolf.model.ranking.RankingPerspective
import com.github.merlinths.codegolf.model.ranking.RankingType

interface GolfUrls{
    val base: String
    val solution: String

    fun of(hole: Hole, language: Language): String

    fun ofRanking(
            hole: Hole,
            language: Language,
            type: RankingType,
            perspective: RankingPerspective): String
}