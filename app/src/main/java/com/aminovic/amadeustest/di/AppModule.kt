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
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(app: Application): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong() // 5 MB
        val cacheDirectory = File(app.cacheDir, "http-cache")
        val cache = Cache(cacheDirectory, cacheSize)

        return  OkHttpClient.Builder()
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(okHttpClient: OkHttpClient): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5500/")
            .client(okHttpClient)
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