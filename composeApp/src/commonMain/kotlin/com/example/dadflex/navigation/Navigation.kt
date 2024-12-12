package com.example.dadflex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.gamescreen.GameScreen
import com.example.dadflex.highscorescreen.HighscoreScreen
import com.example.dadflex.menuscreen.MenuScreen
import com.example.dadflex.optionsscreen.OptionsScreen
import com.example.dadflex.preferences.PreferencesHelper

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val name = PreferencesHelper.name
    NavHost(
        navController = navController,
        startDestination = if (name.isNullOrEmpty()) Screen.OPTIONS_SCREEN.name else Screen.MENU_SCREEN.name,
        modifier = modifier,
    ) {
        composable(route = Screen.MENU_SCREEN.name) {
            MenuScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = Screen.GAME_SCREEN.name) {
            GameScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = Screen.HIGHSCORE_SCREEN.name) {
            HighscoreScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = Screen.OPTIONS_SCREEN.name) {
            OptionsScreen(
                navController = navController,
                modifier = modifier
            )
        }

    }
}



