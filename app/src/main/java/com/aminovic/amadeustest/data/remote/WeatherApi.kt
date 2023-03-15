package com.aminovic.amadeustest.data.remote

import com.aminovic.amadeustest.data.remote.dto.WeatherDto
import retrofit2.http.GET

interface WeatherApi {
    @GET("aminovicnouri/e7a11cd34551f767ae341a10c692cf23/raw/be44472e0f4780d545dde47a181908b0a02dd852/weather_api.json")
    suspend fun getWeatherData(): WeatherDto
}