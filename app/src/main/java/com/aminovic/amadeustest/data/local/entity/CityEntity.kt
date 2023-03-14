package com.aminovic.amadeustest.data.local.entity

import androidx.room.Entity

@Entity
data class CityEntity(
    val cityId: Int?,
    val cityName: String?,
    val findName: String?,
    val country: String?,
    val lon: Double?,
    val lat: Double?,
    val zoom: Int?,
    val time: Int?,
    val temp: Double?,
    val pressure: Int?,
    val humidity: Int?,
    val tempMin: Double?,
    val tempMax: Double?,
    val windSpeed: Double?,
    val windDeg: Int?,
    val windVarBeg: Int?,
    val windVarEnd: Int?,
    val clouds: Int?,
    val rain: Double?,
    var weather: List<WeatherDescriptionLocal> = emptyList()
)

