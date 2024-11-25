package com.example.dadflex.gamescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun GameScreen(
    modifier: Modifier
){
    Column (
        modifier = modifier,
    ) {
        Text(text = "Game Screen")
    }
}