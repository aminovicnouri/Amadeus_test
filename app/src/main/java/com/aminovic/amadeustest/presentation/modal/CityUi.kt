package com.aminovic.amadeustest.presentation.modal

import androidx.annotation.DrawableRes
import com.aminovic.amadeustest.domain.modal.WeatherDescription
import java.time.LocalDateTime

data class CityUi(
    val cityId: Int?,
    val cityName: String?,
    val findName: String?,
    @DrawableRes
    val country: Int?,
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
    var weather: List<WeatherDescription> = emptyList(),
    @DrawableRes
    val image: Int?
)

