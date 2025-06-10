package com.example.myweather.ui.weatherscreen.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
    isScrolled: Boolean,
    modifier: Modifier = Modifier
) {
    val temperatureOffsetX by animateDpAsState(if (isScrolled) 90.dp else 0.dp, tween(400))

    val imageOffsetX by animateDpAsState(if (isScrolled) (-100).dp else 0.dp, tween(400))
    val imageOffsetY by animateDpAsState(if (isScrolled) 28.dp else 0.dp, tween(400))

    val boxHeight by animateDpAsState(if (isScrolled) 143.dp else 355.dp, tween(400))
    val imageHeight by animateDpAsState(if (isScrolled) 112.dp else 200.dp, tween(400))

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(boxHeight)
    ) {
        BluredImage(
            painter = painterResource(state.currentWeather.imageRes),
            isDay = state.currentWeather.isDay,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .height(imageHeight)
                .offset(
                    x = imageOffsetX,
                    y = imageOffsetY
                )
        )
        WeatherCondition(
            state = state,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(x = temperatureOffsetX)
        )
    }

}

@Composable
@Preview
fun CurrentWeatherPreview() {
    CurrentWeather(
        imageRes = R.drawable.mainly_clear_night,
    )
}