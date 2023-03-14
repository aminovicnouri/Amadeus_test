package com.aminovic.amadeustest.data.local

import androidx.room.*
import com.aminovic.amadeustest.data.local.entity.CityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(cityEntity: CityEntity)

    @Delete
    suspend fun deleteCity(cityEntity: CityEntity)

    @Query("SELECT * FROM cityEntity")
    fun getAllCities(): Flow<List<CityEntity>>

    @Query(
        """
            SELECT *
            FROM cityEntity
            WHERE findName = :query
        """
    )
    fun getCityByName(query: String): Flow<List<CityEntity>>
}