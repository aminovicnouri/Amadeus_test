package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class CloudsDto(
    @field:Json(name = "all")
    var all: Int? = null
)