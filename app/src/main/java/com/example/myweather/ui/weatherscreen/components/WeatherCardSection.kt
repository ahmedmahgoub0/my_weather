package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweather.R
import com.example.myweather.ui.weatherscreen.uistate.CurrentWeather

data class CardInfo(
    val title: String,
    val value: String,
    val painter: Painter
)

@Composable
fun WeatherCardSection(
    state: CurrentWeather,
    modifier: Modifier = Modifier
) {
    val currentWeatherInfo = listOf(
        CardInfo("Wind", "${state.windSpeed} KM/h", painterResource(R.drawable.ic_fast_wind)),
        CardInfo("Humidity", "${state.humidity} %", painterResource(R.drawable.ic_humidity)),
        CardInfo("Rain", "${state.rain} %", painterResource(R.drawable.ic_rain)),
        CardInfo("UV Index", "${state.uvIndex}", painterResource(R.drawable.ic_uv)),
        CardInfo("Pressure", "${state.pressure} hPa", painterResource(R.drawable.ic_pressure)),
        CardInfo(
            "Feels like", "${state.feelsLikeTemp}°C", painterResource(R.drawable.ic_temperature)
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxWidth()
            .height(236.dp),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(currentWeatherInfo) {
            WeatherCardInfo(
                title = it.title,
                value = it.value,
                painter = it.painter,
                isDay = state.isDay
            )
        }
    }
}

@Composable
@Preview
fun WeatherCardSectionPreview() {
    WeatherCardSection(CurrentWeather(isDay = true, imageRes = R.drawable.mainly_clear))
}

@Composable
@Preview
fun WeatherCardSectionNightPreview() {
    WeatherCardSection(CurrentWeather())
}