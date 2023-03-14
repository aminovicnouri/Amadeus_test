package com.aminovic.amadeustest.di

import android.app.Application
import androidx.room.Room
import com.aminovic.amadeustest.data.local.WeatherDatabase
import com.aminovic.amadeustest.data.remote.WeatherApi
import com.aminovic.amadeustest.data.repository.WeatherRepositoryImpl
import com.aminovic.amadeustest.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5500/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            "weather_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi, database: WeatherDatabase): WeatherRepository {
        return WeatherRepositoryImpl(api = api, dao = database.dao)
    }
}