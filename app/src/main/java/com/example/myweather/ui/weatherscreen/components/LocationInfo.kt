package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.Grey32
import com.example.myweather.ui.theme.Urbanist

@Composable
fun LocationInfo(
    cityName: String,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    val color = if(isDay) Grey32 else White
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = "location icon",
            tint = color
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = cityName,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.5.sp,
            color = color
        )
    }
}

@Composable
@Preview
fun WeatherHeaderPreview() {
    LocationInfo(
        cityName = "Cairo",
        isDay = true
    )
}

@Composable
@Preview
fun WeatherHeaderPreviewNight() {
    LocationInfo(
        cityName = "Cairo",
        isDay = false
    )
}
