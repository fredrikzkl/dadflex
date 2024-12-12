package com.example.dadflex.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dadflex.ui.theme.DadflexTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DadflexHeader(){
    Text(
        text = "Dadflex",
        modifier = Modifier
            .padding(28.dp),
        fontSize = 72.sp,
        color = Color.White,
    )

}

@Preview
@Composable
fun DadHeaderPreview() {
    DadflexTheme {
        DadflexHeader()
    }
}