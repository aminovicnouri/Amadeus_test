package com.aminovic.amadeustest.data.repository

import com.aminovic.amadeustest.data.local.WeatherDao
import com.aminovic.amadeustest.data.mappers.toCity
import com.aminovic.amadeustest.data.mappers.toCityEntity
import com.aminovic.amadeustest.data.remote.WeatherApi
import com.aminovic.amadeustest.domain.modal.City
import com.aminovic.amadeustest.domain.repository.WeatherRepository
import com.aminovic.amadeustest.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepositoryImpl(
    private val dao: WeatherDao,
    private val api: WeatherApi
) : WeatherRepository {
    override fun getAllCities(): Flow<List<City>> {
        return dao.getAllCities().map { listOfEntities ->
            listOfEntities.map { it.toCity() }
        }
    }

    override suspend fun getCities(query: String?, pageSize: Int, pageNumber: Int): List<City> {
        val offset = (pageNumber - 1) * pageSize
        return if (query == null)
            dao.getCities(pageSize, offset).map { it.toCity() }
        else
            dao.getCities(query, pageSize, offset).map { it.toCity() }
    }

    override suspend fun getCityById(id: Int): City? {
        return dao.getCityById(id)?.toCity()
    }

    override suspend fun getCitiesCount(): Int {
        return dao.getCitiesCount()
    }

    override suspend fun insertCity(city: City) {
        dao.insertCity(city.toCityEntity())
    }

    override suspend fun deleteAllCities() {
        dao.deleteAllCities()
    }

    override suspend fun getWeatherData(): Resource<List<City>> {
        return try {
            Resource.Success(api.getWeatherData().cities.map { it.toCityEntity().toCity() })
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "Unknown error occurred")
        }
    }
}