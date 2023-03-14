package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class WeatherDescriptionDto(
    @field:Json(name = "id")
    var id: Int? = null,

    @field:Json(name = "main")
    var main: String? = null,

    @field:Json(name = "description")
    var description: String? = null,

    @field:Json(name = "icon")
    var icon: String? = null
)