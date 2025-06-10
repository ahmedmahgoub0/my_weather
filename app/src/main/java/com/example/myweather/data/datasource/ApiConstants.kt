package com.example.myweather.data.datasource

object ApiConstants {
    const val BASE_URL = "https://api.open-meteo.com"
    const val GET_WEATHER_ENDPOINT = "v1/forecast"
    const val LATITUDE = "latitude"
    const val LONGITUDE = "longitude"
    const val DAILY = "daily"
    const val DAILY_PARAM = "weather_code,temperature_2m_max,temperature_2m_min,uv_index_max"
    const val HOURLY = "hourly"
    const val HOURLY_PARAM = "temperature_2m,weather_code,uv_index"
    const val CURRENT = "current"
    const val CURRENT_PARAM = "is_day,weather_code,wind_speed_10m,relative_humidity_2m,temperature_2m,rain,pressure_msl,apparent_temperature"
    const val TIMEZONE = "timezone"
    const val AUTO = "auto"
}