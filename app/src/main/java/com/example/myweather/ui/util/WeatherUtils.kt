package com.example.myweather.ui.util

import com.example.myweather.R

fun Int.toWeatherCondition(): String {
    return when (this) {
        0 -> return "Clear sky"
        1 -> return "Mainly clear"
        2 -> return "Partly cloudy"
        3 -> return "Overcast"
        45 -> return "Fog"
        48 -> return "Depositing rime fog"
        51 -> return "Light drizzle"
        53 -> return "Moderate drizzle"
        55 -> return "Dense drizzle"
        56 -> return "Light freezing drizzle"
        57 -> return "Dense freezing drizzle"
        61 -> return "Slight rain"
        63 -> return "Moderate rain"
        65 -> return "Heavy rain"
        66 -> return "Light freezing rain"
        67 -> return "Heavy freezing rain"
        71 -> return "Slight snow fall"
        73 -> return "Moderate snow fall"
        75 -> return "Heavy snow fall"
        77 -> return "Snow grains"
        80 -> return "Slight rain showers"
        81 -> return "Moderate rain showers"
        82 -> return "Violent rain showers"
        85 -> return "Slight snow showers"
        86 -> return "Heavy snow showers"
        95 -> return "Thunderstorm"
        96 -> return "Thunderstorm with slight hail"
        99 -> return "Thunderstorm with heavy hail"
        else -> "Unknown"
    }
}

fun getDrawableIdForWeather(isDay: Int, weatherCode: Int): Int{
    return when (isDay == 1) {
        true -> getDrawableIdForDayWeather(weatherCode)
        false -> getDrawableIdForNightWeather(weatherCode)
    }
}

fun getDrawableIdForDayWeather(weatherCode: Int): Int {
    return when (weatherCode) {
        0 -> R.drawable.clear_sky
        1 -> R.drawable.mainly_clear
        2 -> R.drawable.partly_cloud
        3 -> R.drawable.overcast
        45 -> R.drawable.fog
        48 -> R.drawable.depositing_rime_fog
        51 -> R.drawable.drizzle_light
        53 -> R.drawable.drizzle_moderate
        55 -> R.drawable.drizzle_intensity
        56 -> R.drawable.freezing_drizzle_light
        57 -> R.drawable.freezing_drizzle_intensity
        61 -> R.drawable.rain_slight
        63 -> R.drawable.rain_moderate
        65 -> R.drawable.rain_intensity
        71 -> R.drawable.snow_fall_light
        73 -> R.drawable.rain_moderate
        75 -> R.drawable.rain_intensity
        77 -> R.drawable.snow_grains
        80 -> R.drawable.rain_shower_slight
        81 -> R.drawable.rain_shower_moderate
        82 -> R.drawable.rain_shower_violent
        85 -> R.drawable.snow_grains
        86 -> R.drawable.snow_shower_heavy
        95 -> R.drawable.thunderstrom_slight_or_moderate
        96 -> R.drawable.thunderstrom_with_slight_hail
        99 -> R.drawable.thunderstrom_with_heavy_hail
        else -> R.drawable.mainly_clear
    }
}

fun getDrawableIdForNightWeather(weatherCode: Int): Int {
    return when (weatherCode) {
        0 -> R.drawable.clear_sky_night
        1 -> R.drawable.mainly_clear_night
        2 -> R.drawable.partly_cloud_night
        3 -> R.drawable.overcast_night
        45 -> R.drawable.fog_night
        48 -> R.drawable.depositing_rime_fog_night
        51 -> R.drawable.drizzle_light_night
        53 -> R.drawable.drizzle_moderate_night
        55 -> R.drawable.drizzle_intensity_night
        56 -> R.drawable.freezing_drizzle_light
        57 -> R.drawable.freezing_drizzle_intensity
        61 -> R.drawable.rain_slight_night
        63 -> R.drawable.rain_moderate_night
        65 -> R.drawable.rain_intensity_night
        71 -> R.drawable.snow_fall_light_night
        73 -> R.drawable.rain_moderate_night
        75 -> R.drawable.rain_intensity_night
        77 -> R.drawable.snow_grains
        80 -> R.drawable.rain_shower_slight_night
        81 -> R.drawable.rain_shower_moderate_night
        82 -> R.drawable.rain_shower_violent_night
        85 -> R.drawable.snow_grains
        86 -> R.drawable.snow_shower_heavy
        95 -> R.drawable.thunderstrom_slight_or_moderate
        96 -> R.drawable.thunderstrom_with_slight_hail
        99 -> R.drawable.thunderstrom_with_heavy_hail_night
        else -> R.drawable.mainly_clear_night
    }
}
