package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class WindDto(
    @field:Json(name = "speed")
    var speed: Double? = null,

    @field:Json(name = "deg")
    var deg: Double? = null,

    @field:Json(name = "var_beg")
    var varBeg: Double? = null,

    @field:Json(name = "var_end")
    var varEnd: Double? = null
)