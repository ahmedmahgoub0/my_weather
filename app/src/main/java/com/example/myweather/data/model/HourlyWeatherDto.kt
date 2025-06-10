package com.example.myweather.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class HourlyWeatherDto(
	@SerialName("weather_code") val weatherCode: List<Int?>? = null,
	@SerialName("time") val time: List<String?>? = null,
	@SerialName("temperature_2m") val temperature: List<Double?>? = null
)