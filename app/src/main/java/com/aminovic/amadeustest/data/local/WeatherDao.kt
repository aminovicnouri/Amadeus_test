package com.aminovic.amadeustest.data.local

import androidx.room.*
import com.aminovic.amadeustest.data.local.entity.CityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(cityEntity: CityEntity)

    @Query("DELETE FROM cityEntity")
    suspend  fun deleteAllCities()

    @Query("SELECT * FROM cityEntity")
    fun getAllCities(): Flow<List<CityEntity>>

    @Query("SELECT * FROM cityEntity ORDER BY cityId LIMIT :limit OFFSET :offset")
    suspend fun getCities(limit: Int, offset: Int): List<CityEntity>

    @Query("SELECT COUNT(*) FROM cityEntity")
    suspend  fun getCitiesCount(): Int

    @Query(
        """
            SELECT *
            FROM cityEntity
            WHERE findName = :query
        """
    )
    fun getCityByName(query: String): Flow<List<CityEntity>>
}