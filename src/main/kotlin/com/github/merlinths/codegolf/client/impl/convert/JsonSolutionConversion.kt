package com.github.merlinths.codegolf.client.impl.convert

import com.github.merlinths.codegolf.client.impl.json.JsonSolution
import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Solution

fun createJsonSolution(
        solution: Solution,
        hole: Hole
) = JsonSolution(
        code = solution.code,
        hole = hole.name,
        lang = solution.language.name.lowercase()
)