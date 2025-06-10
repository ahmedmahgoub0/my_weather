package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.DarkGrey
import com.example.myweather.ui.theme.Urbanist
import com.example.myweather.ui.weatherscreen.uistate.HourlyWeather

@Composable
fun TodayHourlyWeather(
    state: HourlyWeather,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Today",
            modifier = Modifier.padding(start = 12.dp),
            fontFamily = Urbanist,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
            color = if (isDay) DarkGrey else White
        )
        LazyRow(
            modifier = Modifier.padding(top = 12.dp),
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                count = state.weatherCode.size,
            ) { index ->
                HourlyWeatherCard(
                    hourlyWeather = HourlyWeatherCardInfo(
                        imageRes = state.imageRes[index],
                        temperature = state.temperature[index],
                        time = state.time[index]
                    ),
                    isDay = isDay
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TodayHourlyWeatherPreview() {
    TodayHourlyWeather(HourlyWeather(imageRes = listOf(R.drawable.mainly_clear)), true)
}