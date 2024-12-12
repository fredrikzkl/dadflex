package com.example.dadflex.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dadflex.ui.theme.DadPrimary
import com.example.dadflex.ui.theme.DadflexTheme
import com.example.dadflex.ui.theme.JerseyFontFamily
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DadButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
    buttonLabel: String? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Button(
            shape = RectangleShape,
            modifier = Modifier
                .border(3.dp, Color.White)
                .shadow(8.dp),
            colors = ButtonDefaults.buttonColors(DadPrimary),
            onClick = onButtonClick

        ) {
            Text(
                text = buttonLabel?: "",
                fontFamily = JerseyFontFamily(),
                fontSize = 24.sp,
            )
        }
    }
}

@Preview()
@Composable
fun DadButtonPreview() {
    DadflexTheme {
        DadButton(buttonLabel = "Play")
    }
}
