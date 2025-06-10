package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.Grey60
import com.example.myweather.ui.theme.Grey70
import com.example.myweather.ui.theme.Grey8
import com.example.myweather.ui.theme.Grey87
import com.example.myweather.ui.theme.Urbanist
import com.example.myweather.ui.theme.White60
import com.example.myweather.ui.theme.White70
import com.example.myweather.ui.theme.White8
import com.example.myweather.ui.theme.White87

data class HourlyWeatherCardInfo(
    val imageRes: Int,
    val temperature: Int,
    val time: String
)

@Composable
fun HourlyWeatherCard(
    hourlyWeather: HourlyWeatherCardInfo,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(88.dp, 132.dp)) {
        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp))
                .background(if(isDay) White70 else Grey70)
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(20.dp),
                    color = if(isDay) Grey8 else White8)
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            BluredImage(
                painter = painterResource(hourlyWeather.imageRes),
                isDay = isDay,
                blurSize = 20,
                imageWidth = 64,
                imageHeight = 58
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "${hourlyWeather.temperature}°C",
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                color = if (isDay) Grey87 else White87
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = hourlyWeather.time,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                color = if (isDay) Grey60 else White60
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HourlyWeatherCardPreview() {
    HourlyWeatherCard(
        HourlyWeatherCardInfo(
            imageRes = R.drawable.mainly_clear_night,
            temperature = 25,
            time = "11:00"
        ),
        true
    )
}