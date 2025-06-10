package com.example.myweather.ui.weatherscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweather.R
import com.example.myweather.ui.theme.BlurNight
import com.example.myweather.ui.theme.Purple

@Composable
fun BluredImage(
    painter: Painter,
    isDay: Boolean,
    modifier: Modifier = Modifier,
    blurSize: Int = 150,
    imageWidth: Int = 220,
    imageHeight: Int = 200,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .height((imageHeight/2).dp)
                .aspectRatio(imageWidth.toFloat() / imageHeight.toFloat())
                .align(Alignment.Center)
                .blur(blurSize.dp, BlurredEdgeTreatment.Unbounded)
                .background(if (isDay) BlurNight else Purple)
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.height(imageHeight.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BluredImagePreview() {
    BluredImage(
        painter = painterResource(R.drawable.mainly_clear_night),
        isDay = true
    )
}

@Composable
@Preview(showBackground = true)
fun BluredImageNightPreview() {
    BluredImage(
        painter = painterResource(R.drawable.mainly_clear_night),
        isDay = false
    )
}
