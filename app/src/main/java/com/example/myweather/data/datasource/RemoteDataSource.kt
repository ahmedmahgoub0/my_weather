package com.example.myweather.data.datasource

import com.example.myweather.data.model.WeatherDto

interface RemoteDataSource {
    suspend fun getWeather(lat: Double, lon: Double): WeatherDto
}