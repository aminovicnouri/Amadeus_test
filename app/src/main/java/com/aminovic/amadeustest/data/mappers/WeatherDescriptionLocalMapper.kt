package com.aminovic.amadeustest.data.mappers

import com.aminovic.amadeustest.data.local.entity.WeatherDescriptionLocal
import com.aminovic.amadeustest.data.remote.dto.WeatherDescriptionDto

fun WeatherDescriptionDto.toWeatherDescriptionLocal(): WeatherDescriptionLocal {
    return WeatherDescriptionLocal(
        id = id,
        main = main,
        description = description,
        icon = icon
    )
}