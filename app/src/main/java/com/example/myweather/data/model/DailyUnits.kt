package com.example.myweather.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class DailyUnits(
	@SerialName("time")	val time: String? = null,
	@SerialName("weather_code")	val weatherCode: String? = null,
	@SerialName("temperature_2m_min") val temperatureMin: String? = null,
	@SerialName("temperature_2m_max") val temperatureMax: String? = null,
	@SerialName("uv_index_max") val uvIndex: String? = null
)