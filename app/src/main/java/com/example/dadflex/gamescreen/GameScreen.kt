package com.example.dadflex.gamescreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.component.BlinkingText
import com.example.dadflex.component.DadButton
import com.example.dadflex.navigation.Screen
import com.example.dadflex.preferences.HighscoreEntry
import com.example.dadflex.preferences.PreferencesHelper
import com.example.dadflex.ui.theme.DadflexTheme
import kotlinx.coroutines.delay
import java.util.Date


@Composable
fun GameScreen(
    modifier: Modifier,
    navController: NavController
){
    val context = LocalContext.current

    var reactionTimer by remember { mutableStateOf(System.currentTimeMillis()); }
    var gameState by remember { mutableStateOf(initialGameState) }
    var startTimer by remember { mutableStateOf((2..10).random()) }
    var showNewHighScoreText by remember { mutableStateOf(false) }

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
        showNewHighScoreText = false;
    }

    fun getReactionTime(): String {
        return if (result > 1000) {
            val seconds = result / 1000
            val milliseconds = result % 1000
            "$seconds S $milliseconds MS"
        } else {
            "$result MS"
        }
    }

    var gameText = gameState.text ?: ""
    if (gameState == completedState) {
        gameText = "${getReactionTime()}"
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

                    // Check if highscore
                    val highscore = PreferencesHelper.getHighscore(context);
                    var name = PreferencesHelper.getName(context);
                    if (name.isNullOrEmpty()){
                        name = "Player";
                    }

                    val newHighScoreAdded = highscore.checkAndAddHighscore(HighscoreEntry(
                        name = name,
                        reactionTime = result,
                        date = Date()
                    ))

                    if (newHighScoreAdded){
                        PreferencesHelper.saveHighscore(context, highscore)
                        showNewHighScoreText = true;
                    }

                } else {
                    gameState = failedState
                }
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        if(gameState == initialGameState) {
            BlinkingText(gameText)
        }else{
            Text(
                modifier = Modifier
                    .padding(32.dp),
                fontSize = 32.sp,
                text = gameText,
                fontWeight = FontWeight.Bold
            )
        }


        if (showNewHighScoreText) {
            BlinkingText("New highscore!")
        }

        if (gameState == failedState || gameState == completedState) {
            DadButton(
                modifier = Modifier
                    .padding(16.dp),
                onButtonClick =  {
                    resetGame()
                },
                buttonLabel = "Try again"
            )

            DadButton(
                modifier = Modifier
                    .padding(16.dp),
                onButtonClick =  {
                    navController.navigate(Screen.MenuScreen.route)
                },
                buttonLabel = "Quit"
            )
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