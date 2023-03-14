package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class RainDto(
    @field:Json(name = "3h")
    var rain3h: Double? = null,
)