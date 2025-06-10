package com.example.myweather.ui.weatherscreen.uistate

import com.example.myweather.data.model.WeatherDto

data class WeatherUiState(
    val isLoading: Boolean = true,
    val cityName: String = "",
    val currentWeather: CurrentWeather = CurrentWeather(),
    val hourlyWeather: HourlyWeather = HourlyWeather(),
    val dailyWeather: DailyWeather = DailyWeather()
)

fun WeatherDto.toUiState(): WeatherUiState {
    return WeatherUiState(
        cityName = timezone ?: "",
        currentWeather = current?.toCurrentWeather() ?: CurrentWeather(),
        hourlyWeather = hourly?.toHourlyWeather(current?.isDay ?: 0) ?: HourlyWeather(),
        dailyWeather = daily?.toDailyWeather(current?.isDay ?: 0) ?: DailyWeather()
    )
}