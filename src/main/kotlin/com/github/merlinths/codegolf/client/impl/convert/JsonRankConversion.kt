package com.github.merlinths.codegolf.client.impl.convert

import com.github.merlinths.codegolf.client.impl.json.JsonRank
import com.github.merlinths.codegolf.model.Golfer
import com.github.merlinths.codegolf.model.ranking.Rank

/**
 * Converts [JsonRank] to golf data class [Rank].
 */
fun JsonRank.toRank() =
        Rank(
                position = position,
                isMe = isMe,
                chars = chars,
                bytes = bytes,
                golfer = Golfer(
                        name = golfer.name,
                        id = golfer.id
                )
        )