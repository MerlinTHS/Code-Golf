package com.github.merlinths.codegolf.client.impl.convert

import com.github.merlinths.codegolf.client.impl.json.JsonResult
import com.github.merlinths.codegolf.model.Result

/**
 * Converts [JsonResult] to golf data class [Result].
 */
fun JsonResult.toResult() =
        Result(
                expected = expected,
                actual = actual,
                successful = successful,
                arguments = arguments
        )