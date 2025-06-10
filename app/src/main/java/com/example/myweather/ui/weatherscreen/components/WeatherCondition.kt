package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.ui.theme.DarkGrey
import com.example.myweather.ui.theme.Grey60
import com.example.myweather.ui.theme.Grey8
import com.example.myweather.ui.theme.Urbanist
import com.example.myweather.ui.theme.White60
import com.example.myweather.ui.theme.White8
import com.example.myweather.ui.weatherscreen.uistate.WeatherUiState

@Composable
fun WeatherCondition(
    state: WeatherUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${state.currentWeather.temperature}°C",
            fontFamily = Urbanist,
            fontWeight = FontWeight.SemiBold,
            fontSize = 64.sp,
            letterSpacing = 0.25.sp,
            color = if (state.currentWeather.isDay) DarkGrey else White
        )

        Text(
            text = state.currentWeather.condition,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            color = if (state.currentWeather.isDay) Grey60 else White60
        )

        HighLowTemperature(
            modifier = Modifier
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(if(state.currentWeather.isDay) Grey8 else White8)
                .padding(horizontal = 24.dp, vertical = 8.dp),
            highTemperature = state.dailyWeather.highTemperature[0],
            lowTemperature = state.dailyWeather.lowTemperature[0],
            isDay = state.currentWeather.isDay,
            separationWidth = 8
        )
    }
}

@Composable
@Preview(showBackground = true)
fun WeatherConditionPreview() {
    WeatherCondition(state = WeatherUiState())
}
