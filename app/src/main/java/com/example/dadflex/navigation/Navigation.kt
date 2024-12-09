package com.example.dadflex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    val name = PreferencesHelper.getName(context)
    NavHost(
        navController = navController,
        startDestination = if (name.isNullOrEmpty()) Screen.OptionsScreen.route else Screen.MenuScreen.route,
    ) {
        composable(Screen.MenuScreen.route) {
            MenuScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Screen.GameScreen.route) {
            GameScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Screen.HighscoreScreen.route) {
            HighscoreScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Screen.OptionsScreen.route) {
            OptionsScreen(
                navController = navController,
                modifier = modifier
            )
        }

    }
}



