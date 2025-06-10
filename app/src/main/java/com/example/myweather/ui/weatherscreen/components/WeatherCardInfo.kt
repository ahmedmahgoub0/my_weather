package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.Cyan
import com.example.myweather.ui.theme.Grey60
import com.example.myweather.ui.theme.Grey70
import com.example.myweather.ui.theme.Grey8
import com.example.myweather.ui.theme.Grey87
import com.example.myweather.ui.theme.Urbanist
import com.example.myweather.ui.theme.White60
import com.example.myweather.ui.theme.White70
import com.example.myweather.ui.theme.White8
import com.example.myweather.ui.theme.White87

@Composable
fun WeatherCardInfo(
    title: String,
    value: String,
    painter: Painter,
    isDay: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .height(115.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(if (isDay) White70 else Grey70)
            .border(
                width = 1.dp,
                color = if (isDay) Grey8 else White8,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = Cyan
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = value,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
            color = if (isDay) Grey87 else White87,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(92.dp)
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = title,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            color = if (isDay) Grey60 else White60,
            modifier = Modifier.width(92.dp)
        )
    }

}

@Composable
@Preview()
fun WeatherCardInfoPreview() {
    WeatherCardInfo(
        painter = painterResource(R.drawable.ic_fast_wind),
        title = "Wind",
        value = "13 KM/h",
        isDay = true
    )
}

@Composable
@Preview()
fun WeatherCardInfoFalsePreview() {
    WeatherCardInfo(
        painter = painterResource(R.drawable.ic_fast_wind),
        title = "Wind",
        value = "13 KM/h",
        isDay = false
    )
}