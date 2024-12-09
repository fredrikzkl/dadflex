package com.example.dadflex.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import android.graphics.Paint
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dadflex.ui.theme.DadflexTheme

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

@Preview(showBackground = true)
@Composable
fun DadHeaderPreview() {
    DadflexTheme {
        DadflexHeader()
    }
}