package com.example.myweather.ui.weatherscreen.uistate

import com.example.myweather.data.model.DailyWeatherDto
import com.example.myweather.ui.util.getDrawableIdForWeather
import com.example.myweather.ui.util.toDayName

data class DailyWeather(
    val weatherCode: List<Int> = emptyList(),
    val imageRes: List<Int> = emptyList(),
    val day: List<String> = emptyList(),
    val highTemperature: List<Int> = emptyList(),
    val lowTemperature: List<Int> = emptyList()
)

fun DailyWeatherDto.toDailyWeather(isDay: Int): DailyWeather {
    return DailyWeather(
        weatherCode = weatherCode?.map { it?.toInt() ?: 0 } ?: emptyList(),
        imageRes = weatherCode?.map { getDrawableIdForWeather(isDay, it?.toInt() ?: 0) }
            ?: emptyList(),
        day = time?.map { it?.toDayName() ?: "" } ?: emptyList(),
        highTemperature = temperatureMax?.map { it?.toInt() ?: 0 } ?: emptyList(),
        lowTemperature = temperatureMin?.map { it?.toInt() ?: 0 } ?: emptyList()
    )
}
