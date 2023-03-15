package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "data")
    val cities: List<WeatherDataDto>
)
