package com.github.merlinths.codegolf.client.impl.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JsonRankTest {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Test
    fun `Json encoding works with ranking array`() {
        val serializedRanks = """[{"bytes":136,"bytes_chars":136,"chars":111,"chars_bytes":315,"golfer":{"id":9773683,"name":"rucin93"},"me":false,"rank":1},{"bytes":138,"bytes_chars":138,"chars":112,"chars_bytes":319,"golfer":{"id":2333628,"name":"o0lit3"},"me":false,"rank":2},{"bytes":138,"bytes_chars":138,"chars":112,"chars_bytes":319,"golfer":{"id":16500803,"name":"emplv"},"me":false,"rank":2},{"bytes":138,"bytes_chars":138,"chars":112,"chars_bytes":319,"golfer":{"id":73640694,"name":"vlpx"},"me":false,"rank":2},{"bytes":140,"bytes_chars":140,"chars":130,"chars_bytes":391,"golfer":{"id":13007891,"name":"Argeento"},"me":false,"rank":5},{"bytes":143,"bytes_chars":143,"chars":115,"chars_bytes":331,"golfer":{"id":36267179,"name":"Irratix"},"me":false,"rank":6},{"bytes":147,"bytes_chars":147,"chars":117,"chars_bytes":336,"golfer":{"id":1552641,"name":"JayXon"},"me":false,"rank":7}]"""

        val deserializedRanks = json.decodeFromString<JsonRanking>(serializedRanks)
        assert(deserializedRanks.isNotEmpty())

        val firstRank = deserializedRanks.first()
        val expectedFirstRank = JsonRank(
                bytes = 136,
                chars = 111,
                golfer = JsonGolfer(id = 9773683, name = "rucin93"),
                position = 1,
                isMe = false,
        )
        assertEquals(expectedFirstRank, firstRank)
    }
}