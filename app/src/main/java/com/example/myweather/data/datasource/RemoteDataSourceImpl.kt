package com.example.myweather.data.datasource

import com.example.myweather.data.datasource.ApiConstants.AUTO
import com.example.myweather.data.datasource.ApiConstants.BASE_URL
import com.example.myweather.data.datasource.ApiConstants.CURRENT
import com.example.myweather.data.datasource.ApiConstants.CURRENT_PARAM
import com.example.myweather.data.datasource.ApiConstants.DAILY
import com.example.myweather.data.datasource.ApiConstants.DAILY_PARAM
import com.example.myweather.data.datasource.ApiConstants.GET_WEATHER_ENDPOINT
import com.example.myweather.data.datasource.ApiConstants.HOURLY
import com.example.myweather.data.datasource.ApiConstants.HOURLY_PARAM
import com.example.myweather.data.datasource.ApiConstants.LATITUDE
import com.example.myweather.data.datasource.ApiConstants.LONGITUDE
import com.example.myweather.data.datasource.ApiConstants.TIMEZONE
import com.example.myweather.data.model.WeatherDto
import com.example.myweather.data.datasource.RemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class RemoteDataSourceImpl(
    val client: HttpClient
) : RemoteDataSource {
    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherDto {
        return client.get("$BASE_URL/$GET_WEATHER_ENDPOINT") {
                parameter(LATITUDE, latitude)
                parameter(LONGITUDE, longitude)
                parameter(DAILY, DAILY_PARAM)
                parameter(HOURLY, HOURLY_PARAM)
                parameter(CURRENT, CURRENT_PARAM)
                parameter(TIMEZONE, AUTO)
            }.body()
    }
}
