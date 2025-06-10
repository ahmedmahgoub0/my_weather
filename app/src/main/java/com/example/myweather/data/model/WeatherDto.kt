package com.example.myweather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerialName("longitude") val longitude: Double? = null,
    @SerialName("latitude") val latitude: Double? = null,
    @SerialName("timezone") val timezone: String? = null,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String? = null,
    @SerialName("elevation") val elevation: Double? = null,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int? = null,
    @SerialName("generationtime_ms") val generationtimeMs: Double? = null,
    @SerialName("current") val current: CurrentWeatherDto? = null,
    @SerialName("current_units") val currentUnits: CurrentUnits? = null,
    @SerialName("daily") val daily: DailyWeatherDto? = null,
    @SerialName("daily_units") val dailyUnits: DailyUnits? = null,
    @SerialName("hourly") val hourly: HourlyWeatherDto? = null,
    @SerialName("hourly_units") val hourlyUnits: HourlyUnits? = null
)