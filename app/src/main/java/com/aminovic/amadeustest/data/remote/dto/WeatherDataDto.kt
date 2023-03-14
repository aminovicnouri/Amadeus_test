package com.aminovic.amadeustest.data.remote.dto

import com.squareup.moshi.Json

data class WeatherDataDto(
    @field:Json(name = "city")
    var cityDto: CityDto? = CityDto(),

    @field:Json(name = "time")
    var time: Int? = null,

    @field:Json(name = "main")
    var main: MainDto? = MainDto(),

    @field:Json(name = "wind")
    var windDto: WindDto? = WindDto(),

    @field:Json(name = "clouds")
    var clouds: CloudsDto? = CloudsDto(),

    @field:Json(name = "rain")
    var rain: RainDto? = RainDto(),

    @field:Json(name = "weather")
    var weather: ArrayList<WeatherDescriptionDto> = arrayListOf()
)


