package com.example.myweather.ui.weatherscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweather.ui.theme.Cyan
import com.example.myweather.ui.theme.DarkGrey
import com.example.myweather.ui.theme.DarkGrey2
import com.example.myweather.ui.weatherscreen.components.CurrentWeather
import com.example.myweather.ui.weatherscreen.components.LocationInfo
import com.example.myweather.ui.weatherscreen.components.TodayHourlyWeather
import com.example.myweather.ui.weatherscreen.components.WeatherCardSection
import com.example.myweather.ui.weatherscreen.components.WeeklyWeather
import com.example.myweather.ui.weatherscreen.uistate.WeatherUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    if (!state.isLoading) WeatherScreenContent(state)
}

@Composable
fun WeatherScreenContent(
    state: WeatherUiState,
) {
    val backgroundColors = when (state.currentWeather.isDay) {
        true -> listOf(Cyan, White)
        false -> listOf(DarkGrey, DarkGrey2)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = backgroundColors))
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LocationInfo(
            cityName = state.cityName,
            isDay = state.currentWeather.isDay,
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(horizontal = 12.dp)
        )
        CurrentWeather(
            state = state, Modifier
                .padding(top = 12.dp)
                .padding(horizontal = 12.dp)
        )
        WeatherCardSection(
            state.currentWeather,
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(horizontal = 12.dp)
        )
        TodayHourlyWeather(
            state.hourlyWeather,
            state.currentWeather.isDay,
            modifier = Modifier.padding(top = 24.dp)
        )
        WeeklyWeather(
            state.dailyWeather,
            state.currentWeather.isDay,
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(horizontal = 12.dp)
        )
        Spacer(Modifier.height(32.dp))
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun WeatherScreenContentPreview() {
    WeatherScreenContent(WeatherUiState())
}
