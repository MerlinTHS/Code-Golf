package com.github.merlinths.codegolf.model.ranking

import com.github.merlinths.codegolf.model.Golfer

data class Rank(
        val golfer: Golfer,
        val position: Int
)