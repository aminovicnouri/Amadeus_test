package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class CoordDto(
    @field:Json(name = "lon")
    var lon: Double? = null,

    @field:Json(name = "lat")
    var lat: Double? = null
)