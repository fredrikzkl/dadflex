package com.example.dadflex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.gamescreen.GameScreen
import com.example.dadflex.menuscreen.MenuScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MenuScreen.route,
    ) {
        composable(Screen.MenuScreen.route) {
            MenuScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(Screen.GameScreen.route) {
            GameScreen(
                modifier = modifier
            )
        }
    }
}



