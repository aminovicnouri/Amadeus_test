package com.aminovic.amadeustest.domain.modal

import java.time.LocalDateTime

data class City(
    val cityId: Int?,
    val cityName: String?,
    val findName: String?,
    val country: String?,
    val lon: Double?,
    val lat: Double?,
    val zoom: Int?,
    val time: LocalDateTime?,
    val temp: Double?,
    val pressure: Double?,
    val humidity: Int?,
    val tempMin: Double?,
    val tempMax: Double?,
    val windSpeed: Double?,
    val windDeg: Double?,
    val windVarBeg: Double?,
    val windVarEnd: Double?,
    val clouds: Int?,
    val rain: Double?,
    var weather: List<WeatherDescription> = emptyList()
)

