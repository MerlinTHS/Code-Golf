package com.github.merlinths.codegolf.engine

import com.github.merlinths.codegolf.model.Hole
import com.github.merlinths.codegolf.model.Solution

interface GolfEngine {

    /**
     * Checks if [solution] passes the CodeGolf tests.
     *
     */
    suspend fun check(hole: Hole, solution: Solution): Boolean
}