package com.aminovic.amadeustest.domain.repository

import com.aminovic.amadeustest.domain.modal.City
import com.aminovic.amadeustest.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getAllCities(): Flow<List<City>>
    fun searchCity(query: String): Flow<List<City>>
    suspend fun insertCity(city: City)
    suspend fun deleteAllCities()
    suspend fun getWeatherData(): Resource<List<City>>
}