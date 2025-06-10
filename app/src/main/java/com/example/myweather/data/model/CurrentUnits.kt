package com.example.myweather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnits(
    @SerialName("wind_speed_10m") val windSpeed: String? = null,
    @SerialName("pressure_msl") val pressure: String? = null,
    @SerialName("temperature_2m") val temperature: String? = null,
    @SerialName("rain") val rain: String? = null,
    @SerialName("relative_humidity_2m") val relativeHumidity: String? = null,
    @SerialName("is_day") val isDay: String? = null,
    @SerialName("apparent_temperature") val apparentTemperature: String? = null,
    @SerialName("interval") val interval: String? = null,
    @SerialName("time") val time: String? = null,
    @SerialName("weather_code") val weatherCode: String? = null
)