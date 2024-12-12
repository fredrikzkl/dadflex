package com.example.dadflex

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.dadflex.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Dadflex",
    ) {
        App()
    }
}