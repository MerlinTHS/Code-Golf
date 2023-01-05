package com.github.merlinths.codegolf.client.impl

import com.github.merlinths.codegolf.client.GolfClient
import com.github.merlinths.codegolf.client.impl.convert.createJsonSolution
import com.github.merlinths.codegolf.client.impl.convert.toRank
import com.github.merlinths.codegolf.client.impl.convert.toResult
import com.github.merlinths.codegolf.client.impl.json.JsonRanking
import com.github.merlinths.codegolf.client.impl.json.JsonResult
import com.github.merlinths.codegolf.client.impl.json.JsonSolution
import com.github.merlinths.codegolf.client.url.GolfUrls
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import com.github.merlinths.codegolf.model.Result
import com.github.merlinths.codegolf.model.Solution
import com.github.merlinths.codegolf.model.ranking.RankingPerspective
import com.github.merlinths.codegolf.model.ranking.RankingType
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorGolfClient(
        engine: HttpClientEngine,
        private val url: GolfUrls
) : GolfClient {
    private val httpClient = configureHttpClient(engine)

    override suspend fun postSolution(
            hole: Hole,
            solution: Solution
    ): Result =
            receiveJsonResult(
                url = url.solution,
                solution = createJsonSolution(solution, hole)
            ).toResult()

    override suspend fun getRanking(
            hole: Hole,
            language: Language,
            type: RankingType,
            perspective: RankingPerspective
    ) = buildList {
        receiveJsonRanking(url.ofRanking(hole, language, type, perspective))
                .map { it.toRank() }
                .forEach(this::add)
    }

    private suspend fun receiveJsonRanking(
            url: String
    ) = httpClient.get(url)
            .body<JsonRanking>()

    private suspend fun receiveJsonResult(
            url: String,
            solution: JsonSolution
    ) = httpClient.post(url) {
            contentType(ContentType.Application.Json)
            setBody(solution)
        }.body<JsonResult>()
}