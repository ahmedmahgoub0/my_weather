package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweather.R
import com.example.myweather.ui.weatherscreen.uistate.CurrentWeather
import com.example.myweather.ui.weatherscreen.uistate.WeatherUiState

@Composable
fun CurrentWeather(
    state: WeatherUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BluredImage(
            painter = painterResource(state.currentWeather.imageRes),
            isDay = state.currentWeather.isDay,
            modifier = Modifier
        )
        WeatherCondition(state = state)
    }
}

@Composable
@Preview
fun CurrentWeatherPreview() {
    CurrentWeather(
        imageRes = R.drawable.mainly_clear_night,
    )
}