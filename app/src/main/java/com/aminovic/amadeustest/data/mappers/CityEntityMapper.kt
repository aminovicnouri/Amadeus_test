package com.aminovic.amadeustest.data.mappers

import com.aminovic.amadeustest.data.local.entity.CityEntity
import com.aminovic.amadeustest.data.remote.dto.WeatherDataDto
import com.aminovic.amadeustest.domain.modal.City
import java.time.ZoneOffset

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
        temp = ((main?.temp?.minus(32))?.times(5))?.div(9),
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

fun City.toCityEntity(): CityEntity {
    return CityEntity(
        cityId = cityId,
        cityName = cityName,
        findName = findName,
        country = country,
        lon = lon,
        lat = lat,
        zoom = zoom,
        time = time?.toEpochSecond(ZoneOffset.UTC),
        temp = temp,
        pressure = pressure,
        humidity = humidity,
        tempMin = tempMin,
        tempMax = tempMax,
        windSpeed = windSpeed,
        windDeg = windDeg,
        windVarBeg = windVarBeg,
        windVarEnd = windVarEnd,
        clouds = clouds,
        rain = rain,
        weather = weather.map { it.toWeatherDescriptionLocal() }
    )
}