package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.Grey24
import com.example.myweather.ui.theme.Grey60
import com.example.myweather.ui.theme.Urbanist
import com.example.myweather.ui.theme.White24
import com.example.myweather.ui.theme.White87

@Composable
fun HighLowTemperature(
    highTemperature: Int,
    lowTemperature: Int,
    isDay: Boolean,
    modifier: Modifier = Modifier,
    separationWidth: Int = 4
) {
    val contentColor = if (isDay) Grey60 else White87
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_up),
            contentDescription = null,
            tint = contentColor
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = "$highTemperature°C",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
            color = contentColor
        )
        Spacer(Modifier.width(separationWidth.dp))
        Box(
            modifier = Modifier
                .size(1.dp, 14.dp)
                .background(if (isDay) Grey24 else White24)
        )
        Spacer(Modifier.width(separationWidth.dp))
        Icon(
            painter = painterResource(R.drawable.ic_arrow_down),
            contentDescription = null,
            tint = contentColor
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = "$lowTemperature°C",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
            color = contentColor
        )
    }
}

@Composable
@Preview
fun HighLowTemperaturePreview() {
    HighLowTemperature(
        highTemperature = 32,
        lowTemperature = 20,
        isDay = true
    )
}

