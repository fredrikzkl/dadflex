package com.example.dadflex.menuscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.component.DadButton
import com.example.dadflex.component.DadflexHeader
import com.example.dadflex.navigation.Screen
import com.example.dadflex.ui.theme.DadBlue
import com.example.dadflex.ui.theme.DadflexTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MenuScreen(
    modifier: Modifier,
    navController: NavController
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(DadBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        DadflexHeader()
        Menu(modifier, navController)
    }
}



@Composable
fun Menu(modifier : Modifier, navController: NavController){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        DadButton(
            modifier = modifier,
            onButtonClick = {
                navController.navigate(Screen.GAME_SCREEN.name)
            },
            buttonLabel = "Play"
        )
        DadButton(
            modifier = modifier,
            onButtonClick = {
                navController.navigate(Screen.HIGHSCORE_SCREEN.name)
            },
            buttonLabel = "Highscores"

        )
        DadButton(
            modifier = modifier,
            onButtonClick = {
                navController.navigate(Screen.OPTIONS_SCREEN.name)
            },
            buttonLabel = "Options"
        )
    }
}


@Preview
@Composable
fun GreetingPreview() {
    DadflexTheme {
        MenuScreen(
            modifier = Modifier,
            navController = rememberNavController()
        )
    }
}