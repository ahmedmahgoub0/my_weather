package com.example.myweather.data.repository

import com.example.myweather.data.model.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}