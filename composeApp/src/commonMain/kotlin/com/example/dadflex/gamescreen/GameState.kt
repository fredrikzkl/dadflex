package com.example.dadflex.gamescreen

import androidx.compose.ui.graphics.Color
import com.example.dadflex.ui.theme.DadGreen
import com.example.dadflex.ui.theme.DadRed
import com.example.dadflex.ui.theme.DadYellow

data class GameState (
    val backgroundColor: Color = Color.Gray,
    val text : String? = ""
)

val initialGameState = GameState(
    backgroundColor = DadYellow,
    text = "Wait..."
)

val readyState = GameState(
    backgroundColor = DadGreen,
    text = "Click now!"
)

val completedState = GameState(
    backgroundColor = DadGreen,
)

val failedState = GameState(
    backgroundColor = DadRed,
    text = "You clicked too early!"
)

