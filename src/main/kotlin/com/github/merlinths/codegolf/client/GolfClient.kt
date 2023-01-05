package com.github.merlinths.codegolf.client

import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import com.github.merlinths.codegolf.model.Result
import com.github.merlinths.codegolf.model.Solution
import com.github.merlinths.codegolf.model.ranking.Ranking
import com.github.merlinths.codegolf.model.ranking.RankingPerspective
import com.github.merlinths.codegolf.model.ranking.RankingType

interface GolfClient {
    suspend fun postSolution(
            hole: Hole,
            solution: Solution
    ): Result

    suspend fun getRanking(
            hole: Hole,
            language: Language,
            type: RankingType,
            perspective: RankingPerspective
    ): Ranking
}