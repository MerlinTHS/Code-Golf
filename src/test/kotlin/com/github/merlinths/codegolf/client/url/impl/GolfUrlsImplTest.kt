package com.github.merlinths.codegolf.client.url.impl

import com.github.merlinths.codegolf.client.url.GolfUrls
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import com.github.merlinths.codegolf.model.ranking.RankingPerspective
import com.github.merlinths.codegolf.model.ranking.RankingType
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GolfUrlsImplTest {
    private lateinit var golfUrl: GolfUrls

    @Before
    fun setup() {
        golfUrl = GolfUrlsImpl()
    }

    @Test
    fun `base is CodeGolf's home url`() {
        assertEquals("https://code.golf", golfUrl.base)
    }

    @Test
    fun `solution is CodeGolf's solution url`() {
        assertEquals("https://code.golf/solution", golfUrl.solution)
    }

    @Test
    fun `of() returns java brainfuck url`() {
        assertEquals(
                "https://code.golf/brainfuck#java",
                golfUrl.of(
                        Hole("brainfuck"),
                        Language.Java
                )
        )
    }

    @Test
    fun `ofRanking() returns javascript catalan numbers url`() {
        val expectedRankingUrl = "https://code.golf/api/mini-rankings/catalan-numbers/javascript/chars/top"
        val rankingUrl = golfUrl.ofRanking(
                hole = Hole(name = "catalan-numbers"),
                language = Language.JavaScript,
                type = RankingType.Chars,
                perspective = RankingPerspective.Top
        )

        assertEquals(expectedRankingUrl, rankingUrl)
    }
}