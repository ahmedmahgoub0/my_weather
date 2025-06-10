package com.example.myweather.data.repository

import com.example.myweather.data.model.WeatherDto

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double): WeatherDto
}