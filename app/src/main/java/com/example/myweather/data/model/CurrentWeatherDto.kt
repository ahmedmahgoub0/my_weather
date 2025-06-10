package com.example.myweather.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class CurrentWeatherDto(
	@SerialName("time") val time: String? = null,
	@SerialName("interval") val interval: Int? = null,
	@SerialName("is_day") val isDay: Int? = null,
	@SerialName("weather_code") val weatherCode: Int? = null,
	@SerialName("wind_speed_10m") val windSpeed: Double? = null,
	@SerialName("relative_humidity_2m") val relativeHumidity: Int? = null,
	@SerialName("temperature_2m") val temperature: Double? = null,
	@SerialName("apparent_temperature") val apparentTemperature: Double? = null,
	@SerialName("rain") val rain: Double? = null,
	@SerialName("pressure_msl") val pressure: Double? = null,
)