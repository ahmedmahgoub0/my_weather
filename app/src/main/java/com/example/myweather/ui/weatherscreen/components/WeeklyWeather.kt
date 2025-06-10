package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.DarkGrey
import com.example.myweather.ui.theme.Grey60
import com.example.myweather.ui.theme.Grey70
import com.example.myweather.ui.theme.Grey8
import com.example.myweather.ui.theme.Urbanist
import com.example.myweather.ui.theme.White60
import com.example.myweather.ui.theme.White70
import com.example.myweather.ui.theme.White8
import com.example.myweather.ui.weatherscreen.uistate.DailyWeather

@Composable
fun WeeklyWeather(
    state: DailyWeather,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Next 7 Days",
            fontFamily = Urbanist,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
            color = if (isDay) DarkGrey else White
        )
        Spacer(Modifier.height(12.dp))
        LazyColumn(
            modifier = Modifier
                .height(435.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(if (isDay) White70 else Grey70)
                .border(
                    width = 1.dp,
                    color = if (isDay) Grey8 else White8,
                    shape = RoundedCornerShape(24.dp)
                ),
            userScrollEnabled = false
        ) {
            items(state.weatherCode.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = state.day[index].capitalize(Locale.current),
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = if (isDay) Grey60 else White60,
                        modifier = Modifier.width(91.dp),
                    )
                    Box(
                        modifier = Modifier
                            .size(91.dp, 45.dp)
                            .padding(vertical = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(state.imageRes[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )
                    }
                    HighLowTemperature(
                        highTemperature = state.highTemperature[index],
                        lowTemperature = state.lowTemperature[index],
                        isDay = isDay,

                        )
                }
                if (index != state.weatherCode.size - 1) {
                    HorizontalDivider(
                        modifier =Modifier.fillMaxWidth(),
                        color = if (isDay) Grey8 else White8,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun WeeklyWeatherPreview() {
    WeeklyWeather(
        state = DailyWeather(
            weatherCode = listOf(1, 2, 3, 4, 5, 6, 7),
            day = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"),
            highTemperature = listOf(10, 11, 12, 13, 14, 15, 16),
            lowTemperature = listOf(5, 6, 7, 8, 9, 10, 11),
            imageRes = listOf(
                R.drawable.mainly_clear_night,
                R.drawable.mainly_clear_night,
                R.drawable.mainly_clear_night,
                R.drawable.mainly_clear_night,
                R.drawable.mainly_clear_night,
                R.drawable.mainly_clear_night,
                R.drawable.mainly_clear_night
            )
        ),
        isDay = true
    )
}