package com.aminovic.amadeustest.data.mappers

import com.aminovic.amadeustest.data.local.entity.CityEntity
import com.aminovic.amadeustest.domain.modal.City
import java.time.LocalDateTime
import java.time.ZoneOffset

fun CityEntity.toCity(): City {
    return City(
        cityId = cityId,
        cityName = cityName,
        findName = findName,
        country = country,
        lon = lon,
        lat = lat,
        zoom = zoom,
        time = time?.let { LocalDateTime.ofEpochSecond(it, 0, ZoneOffset.UTC) },
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
        weather = weather.map { it.toWeatherDescription() },
    )
}
