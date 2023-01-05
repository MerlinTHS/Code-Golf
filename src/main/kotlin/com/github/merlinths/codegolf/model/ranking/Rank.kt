package com.github.merlinths.codegolf.model.ranking

import com.github.merlinths.codegolf.model.Golfer

data class Rank(
        val golfer: Golfer,
        val position: Int,
        val chars: Long,
        val bytes: Long,
        val isMe: Boolean
)