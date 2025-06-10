package com.example.myweather.data.repository

import com.example.myweather.data.datasource.RemoteDataSource
import com.example.myweather.data.model.WeatherDto

class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherDto {
        return try {
            remoteDataSource.getWeather(latitude, longitude)
        } catch (e: Exception) {
            WeatherDto()
        }
    }
}