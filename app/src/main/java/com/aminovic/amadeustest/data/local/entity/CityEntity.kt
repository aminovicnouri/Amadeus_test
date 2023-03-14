package com.aminovic.amadeustest.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
@TypeConverters(WeatherDescriptionLocalTypeConverter::class)
data class CityEntity(
    @PrimaryKey val cityId: Int?,
    val cityName: String?,
    val findName: String?,
    val country: String?,
    val lon: Double?,
    val lat: Double?,
    val zoom: Int?,
    val time: Long?,
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
    var weather: List<WeatherDescriptionLocal> = emptyList()
)

