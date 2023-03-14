package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class MainDto(
    @field:Json(name = "temp")
    var temp: Double? = null,

    @field:Json(name = "pressure")
    var pressure: Int? = null,

    @field:Json(name = "humidity")
    var humidity: Int? = null,

    @field:Json(name = "temp_min")
    var tempMin: Double? = null,

    @field:Json(name = "temp_max")
    var tempMax: Double? = null
)