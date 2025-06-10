package com.example.myweather.ui.weatherscreen.uistate

import com.example.myweather.data.model.HourlyWeatherDto
import com.example.myweather.ui.util.getDrawableIdForWeather
import com.example.myweather.ui.util.toLocalTime

data class HourlyWeather(
    val weatherCode: List<Int> = emptyList(),
    val imageRes: List<Int> = emptyList(),
    val time: List<String> = emptyList(),
    val temperature: List<Int> = emptyList()
)

fun HourlyWeatherDto.toHourlyWeather(isDay: Int): HourlyWeather {
    return HourlyWeather(
        weatherCode = weatherCode?.map { it?.toInt() ?: 0 } ?: emptyList(),
        imageRes = weatherCode?.map { getDrawableIdForWeather(isDay, it?.toInt() ?: 0) }
            ?: emptyList(),
        time = time?.map { it?.toLocalTime() ?: "" } ?: emptyList(),
        temperature = temperature?.map { it?.toInt() ?: 0 } ?: emptyList()
    )
}
