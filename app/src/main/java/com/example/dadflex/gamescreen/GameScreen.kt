package com.example.dadflex.gamescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.navigation.Screen
import com.example.dadflex.ui.theme.DadflexTheme
import kotlinx.coroutines.delay


@Composable
fun GameScreen(
    modifier: Modifier,
    navController: NavController
){
    var reactionTimer by remember { mutableStateOf(System.currentTimeMillis()); }
    var gameState by remember { mutableStateOf(completedState) }
    var startTimer by remember { mutableStateOf((2..10).random()) }

    var result by remember { mutableLongStateOf(0) }

    LaunchedEffect(startTimer) {
        delay(startTimer * 1000L)

        if(gameState == failedState) {
            return@LaunchedEffect;
        }

        gameState = readyState
        reactionTimer = System.currentTimeMillis();
    }

    fun resetGame() {
        gameState = initialGameState
        startTimer = (2..10).random()
    }

    fun getReactionTime(): String {
        return if (result > 1000) {
            val seconds = result / 1000
            val milliseconds = result % 1000
            "$seconds:$milliseconds"
        } else {
            "$result ms"
        }
    }

    var gameText = gameState.text ?: ""
    if (gameState == completedState) {
        gameText = "You took ${getReactionTime()} to react!"
    }

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(gameState.backgroundColor)
            .clickable {
                if (gameState == completedState) {
                    return@clickable
                }

                if (gameState == readyState) {
                    gameState = completedState
                    result = System.currentTimeMillis() - reactionTimer;
                } else {
                    gameState = failedState
                }
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(
            modifier = Modifier.padding(16.dp),
            text = gameText
        )

        if (gameState == failedState || gameState == completedState) {
            Button(
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                resetGame()
            }) {
                Text(text = "Try again")
            }

            Button(
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    navController.navigate(Screen.MenuScreen.route)
                }) {
                Text(text = "Quit")
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    DadflexTheme {
        GameScreen(
            navController = rememberNavController(),
            modifier = Modifier,
        )
    }
}