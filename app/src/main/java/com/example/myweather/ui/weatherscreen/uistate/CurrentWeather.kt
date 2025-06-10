package com.example.myweather.ui.weatherscreen.uistate

import com.example.myweather.data.model.CurrentWeatherDto
import com.example.myweather.ui.util.getDrawableIdForWeather
import com.example.myweather.ui.util.toWeatherCondition

data class CurrentWeather(
    val weatherCode: Int = 0,
    val isDay: Boolean = false,
    val imageRes: Int = 0,
    val temperature: Int = 0,
    val windSpeed: Int = 0,
    val condition: String = "",
    val humidity: Int = 0,
    val rain: Int = 0,
    val pressure: Int = 0,
    val feelsLikeTemp: Int = 0,
    val uvIndex: Int = 0
)

fun CurrentWeatherDto.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        weatherCode = weatherCode ?: 0,
        isDay = isDay == 1,
        imageRes = getDrawableIdForWeather(isDay ?: 0, weatherCode ?: 0),
        temperature = temperature?.toInt() ?: 0,
        windSpeed = windSpeed?.toInt() ?: 0,
        condition = weatherCode?.toWeatherCondition() ?: "",
        humidity = relativeHumidity ?: 0,
        rain = rain?.toInt() ?: 0,
        pressure = pressure?.toInt() ?: 0,
        feelsLikeTemp = apparentTemperature?.toInt() ?: 0,
        uvIndex = apparentTemperature?.toInt() ?: 0
    )
}
