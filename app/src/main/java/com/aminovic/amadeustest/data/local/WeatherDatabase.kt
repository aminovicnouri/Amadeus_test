package com.aminovic.amadeustest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aminovic.amadeustest.data.local.entity.CityEntity

@Database(
    entities = [CityEntity::class],
    version = 1
)
abstract class WeatherDatabase: RoomDatabase() {
    abstract val dao: WeatherDao
}