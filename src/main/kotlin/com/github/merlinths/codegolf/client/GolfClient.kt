package com.github.merlinths.codegolf.client

import com.github.merlinths.codegolf.model.*
import com.github.merlinths.codegolf.model.ranking.Ranking
import com.github.merlinths.codegolf.model.ranking.RankingPerspective
import com.github.merlinths.codegolf.model.ranking.RankingType

interface GolfClient {
    suspend fun postSolution(hole: Hole, solution: Solution): GolfResult
    suspend fun getRanking(type: RankingType, perspective: RankingPerspective): Ranking
}