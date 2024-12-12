package com.example.dadflex.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.dadflex.ui.theme.jerseyFontFamily

@Composable
fun BlinkingText(text: String) {
    val alpha = remember { Animatable(1f) }

    LaunchedEffect(Unit) {
        alpha.animateTo(
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 750),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Text(
        text = text,
       // fontFamily = jerseyFontFamily,
        fontSize = 16.sp,

        modifier = Modifier
            .alpha(alpha.value)
            .padding(16.dp)
    )
}
