package com.github.merlinths.codegolf.service

import com.github.merlinths.codegolf.client.GolfClient

interface GolfService {
    val client: GolfClient
    val golfEditor: GolfEditor
}