package com.aminovic.amadeustest.data.remote

import com.aminovic.amadeustest.data.remote.dto.WeatherDto
import retrofit2.http.GET

interface WeatherApi {
    @GET("http://127.0.0.1:5500/weather_14.json")
    suspend fun getWeatherData(): WeatherDto
}