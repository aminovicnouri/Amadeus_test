package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class CityDto(

    @field:Json(name = "id")
    var id: Int? = null,

    @field:Json(name = "name")
    var name: String? = null,

    @field:Json(name = "findname")
    var findName: String? = null,

    @field:Json(name = "country")
    var country: String? = null,

    @field:Json(name = "coord")
    var coordDto: CoordDto? = CoordDto(),

    @field:Json(name = "zoom")
    var zoom: Int? = null

)