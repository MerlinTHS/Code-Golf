package com.github.merlinths.codegolf.client.url

import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Language

interface GolfUrls{
    val base: String

    fun of(hole: Hole, language: Language): String
}