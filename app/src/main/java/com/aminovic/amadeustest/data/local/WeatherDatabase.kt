package com.aminovic.amadeustest.data.local

import androidx.room.Database
import com.aminovic.amadeustest.data.local.entity.CityEntity

@Database(
    entities = [CityEntity::class],
    version = 1
)
abstract class WeatherDatabase {
    abstract val dao: WeatherDao
}