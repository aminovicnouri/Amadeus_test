package com.aminovic.amadeustest.data.mappers

import com.aminovic.amadeustest.data.local.entity.CityEntity
import com.aminovic.amadeustest.data.remote.dto.WeatherDataDto

fun WeatherDataDto.toCityEntity(): CityEntity {
    return CityEntity(
        cityId = cityDto?.id,
        cityName = cityDto?.name,
        findName = cityDto?.findName,
        country = cityDto?.country,
        lon = cityDto?.coordDto?.lon,
        lat = cityDto?.coordDto?.lat,
        zoom = cityDto?.zoom,
        time = time,
        temp = main?.temp,
        pressure = main?.pressure,
        humidity = main?.humidity,
        tempMin = main?.tempMin,
        tempMax = main?.tempMax,
        windSpeed = windDto?.speed,
        windDeg = windDto?.deg,
        windVarBeg = windDto?.varBeg,
        windVarEnd = windDto?.varEnd,
        clouds = clouds?.all,
        rain = rain?.rain3h,
        weather = weather.map { it.toWeatherDescriptionLocal() }
    )
}