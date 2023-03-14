package com.aminovic.amadeustest.data.mappers

import com.aminovic.amadeustest.data.local.entity.WeatherDescriptionLocal
import com.aminovic.amadeustest.data.remote.dto.WeatherDescriptionDto
import com.aminovic.amadeustest.domain.modal.WeatherDescription

fun WeatherDescriptionDto.toWeatherDescriptionLocal(): WeatherDescriptionLocal {
    return WeatherDescriptionLocal(
        id = id,
        main = main,
        description = description,
        icon = icon
    )
}

fun WeatherDescription.toWeatherDescriptionLocal(): WeatherDescriptionLocal {
    return WeatherDescriptionLocal(
        id = id,
        main = main,
        description = description,
        icon = icon
    )
}


fun WeatherDescriptionLocal.toWeatherDescription(): WeatherDescription {
    return WeatherDescription(
        id = id,
        main = main,
        description = description,
        icon = icon,
    )
}