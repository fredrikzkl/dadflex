package com.example.dadflex.gamescreen

import androidx.compose.ui.graphics.Color

data class GameState (
    val backgroundColor: Color = Color.Gray,
    val text : String? = ""
)

val initialGameState = GameState(
    backgroundColor = Color.Yellow,
    text = "Wait..."
)

val readyState = GameState(
    backgroundColor = Color.Green,
    text = "Click now!"
)

val completedState = GameState(
    backgroundColor = Color.Green,
)

val failedState = GameState(
    backgroundColor = Color.Red,
    text = "You clicked too early!"
)

