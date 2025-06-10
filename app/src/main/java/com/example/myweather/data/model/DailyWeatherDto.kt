package com.example.myweather.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class DailyWeatherDto(
	@SerialName("time")	val time: List<String?>? = null,
	@SerialName("weather_code")	val weatherCode: List<Int?>? = null,
	@SerialName("temperature_2m_min") val temperatureMin: List<Double?>? = null,
	@SerialName("temperature_2m_max") val temperatureMax: List<Double?>? = null,
	@SerialName("uv_index_max") val uvIndex: List<Double?>? = null
)