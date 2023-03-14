package com.aminovic.amadeustest.data.local.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WeatherDescriptionLocalTypeConverter {

    @TypeConverter
    fun fromJson(json: String): List<WeatherDescriptionLocal> {
        val listType = object : TypeToken<List<WeatherDescriptionLocal>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toJson(list: List<WeatherDescriptionLocal>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
