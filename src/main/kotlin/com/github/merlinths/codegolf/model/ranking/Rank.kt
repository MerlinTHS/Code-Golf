package com.github.merlinths.codegolf.model.ranking

import com.github.merlinths.codegolf.model.Golfer
import kotlinx.serialization.Serializable

data class Rank(
        val golfer: Golfer,
        val position: Int
)