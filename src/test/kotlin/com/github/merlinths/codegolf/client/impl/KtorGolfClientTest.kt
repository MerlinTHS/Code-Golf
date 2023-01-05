package com.github.merlinths.codegolf.client.impl

import com.github.merlinths.codegolf.client.GolfClient
import com.github.merlinths.codegolf.client.impl.convert.toRank
import com.github.merlinths.codegolf.client.impl.convert.toResult
import com.github.merlinths.codegolf.client.impl.json.JsonGolfer
import com.github.merlinths.codegolf.client.impl.json.JsonRank
import com.github.merlinths.codegolf.client.impl.json.JsonResult
import com.github.merlinths.codegolf.client.url.impl.GolfUrlsImpl
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language
import com.github.merlinths.codegolf.model.Solution
import com.github.merlinths.codegolf.model.ranking.RankingPerspective
import com.github.merlinths.codegolf.model.ranking.RankingType
import com.intellij.testFramework.UsefulTestCase.assertEmpty
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class KtorGolfClientTest {
    private val golfUrls = GolfUrlsImpl()

    @Nested
    @DisplayName("Mocked")
    inner class MockedTests {
        private val mockedResult = JsonResult(
                expected = "interface x{}",
                actual = "interface x{}",
                successful = true,
                arguments = emptyList()
        )

        // buildList is used for being able to collapse the code in the IDE.
        private val mockedRanking = buildList {
            add(JsonRank(
                    golfer = JsonGolfer(1999, "Marko"),
                    position = 1,
                    bytes = 133,
                    chars = 133,
                    isMe = false
            ))
            add(JsonRank(
                    golfer = JsonGolfer(1999, "Marko"),
                    position = 1,
                    bytes = 133,
                    chars = 133,
                    isMe = false
            ))
        }

        @Test
        fun `Returns mocked ranking`() = runTest {
            val client = createMockedGolfClient(content = Json.encodeToString(mockedRanking))

            val expectedRanking = mockedRanking.map(JsonRank::toRank)
            val ranking = client.getRanking(
                    hole = Hole("brainfuck"),
                    language = Language.Java,
                    type = RankingType.Chars,
                    perspective = RankingPerspective.Top
            )

            assertArrayEquals(expectedRanking.toTypedArray(), ranking.toTypedArray())
        }

        @Test
        fun `Returns mocked solution`() = runTest {
            val client = createMockedGolfClient(content = Json.encodeToString(mockedResult))

            val hole = Hole("brainfuck")
            val solution = Solution(code = "interface x{}", language = Language.Java)

            val result = client.postSolution(hole, solution)
            val expectedResult = mockedResult.toResult()
            assertEquals(expectedResult, result)
        }
    }

    @Nested
    @DisplayName("CodeGolf Server")
    inner class ServerTests {
        @Test
        fun `Solution contains no arguments for catalan-numbers`() = runTest {
            val client = createRealGolfClient()
            val solution = client.postSolution(
                    hole = Hole("catalan-numbers"),
                    solution = Solution(
                            code = "No code needed for this test",
                            language = Language.Java
                    )
            )

            assertEmpty(solution.arguments)
        }

        @Test
        fun `Ranking contains 7 elements`() = runTest {
            val client = createRealGolfClient()

            val ranking = client.getRanking(
                    hole = Hole("brainfuck"),
                    language = Language.Java,
                    type = RankingType.Chars,
                    perspective = RankingPerspective.Top
            )

            assert(ranking.isNotEmpty())
            assertEquals(7, ranking.size)
        }

        @Test
        fun `Invalid result for invalid solution`() = runTest {
            val code = "This is an invalid solution!"
            val client = createRealGolfClient()
            val solution = client.postBrainfuckSolution(code)

            val expectedArguments = listOf<String>()

            assertFalse(solution.successful)
        }

        @Test
        fun `Valid result for valid solution`() = runTest {
            val client = createRealGolfClient()
            val solution = client.postBrainfuckSolution(code = "interface z{static void main(String[]a){for(var b:a)for(char p=0,h=0,s=0,l=0,n=91,i=0,c,m[]=new char[n],y[]=b.toCharArray();i<y.length;c=y[i++],h=s>0?s+=c==n?1:c>n?-1:0:c<44?++m[p]:c<46?--m[p]:c==60?--p:c==62?++p:c>n?m[p]!=0?i=m[n-l]:--l:c==n?m[p]!=0?m[n-++l]=i:++s:h,System.out.print(c==46?m[p]:\"\"));}}")

            assert(solution.successful)
        }

        private suspend fun GolfClient.postBrainfuckSolution(code: String) =
                postSolution(
                        hole = Hole("brainfuck"),
                        solution = Solution(
                                code = code,
                                language = Language.Java
                        )
                )
    }

    private fun createMockedGolfClient(content: String) =
            createGolfClient(
                    engine = createMockEngine(content)
            )

    private fun createRealGolfClient() =
            createGolfClient(engine = CIO.create())

    private fun createMockEngine(content: String) =
            MockEngine {
                respond(
                        content = content,
                        status = HttpStatusCode.OK,
                        headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }

    private fun createGolfClient(engine: HttpClientEngine) =
            KtorGolfClient(
                    engine = engine,
                    url = golfUrls
            )
}