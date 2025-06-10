package com.example.myweather.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class HourlyUnits(
	@SerialName("time")	val time: String? = null,
	@SerialName("temperature_2m") val temperature: String? = null
)