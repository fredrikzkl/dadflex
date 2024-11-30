package com.example.dadflex.highscorescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.gamescreen.GameScreen
import com.example.dadflex.menuscreen.Header
import com.example.dadflex.menuscreen.NameInput
import com.example.dadflex.navigation.Screen
import com.example.dadflex.preferences.HighscoreEntry
import com.example.dadflex.preferences.PreferencesHelper
import com.example.dadflex.ui.theme.DadflexTheme

@Composable
fun HighscoreScreen(
    modifier: Modifier,
    navController: NavController
){
    val context = LocalContext.current

    // Load in highscores
    val highscore = PreferencesHelper.getHighscore(context);
    var highscoreList = highscore.getHighscoreList()

    Column (
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if(highscoreList.isEmpty()){
            Text(text = "No highscores yet!")
        } else {
            HighscoreList(highscoreList)
        }
        Button(
            modifier = modifier,
            onClick = {
                navController.navigate(Screen.MenuScreen.route)
            }
        ){
            Text("Back")
        }
    }
}

@Composable
fun HighscoreList(highscoreList: List<HighscoreEntry>){
    LazyColumn {
        items(highscoreList.size) { index ->
            val highscore = highscoreList[index]
            Row {
                Text(text = highscore.name)
                Text(text = highscore.reactionTime.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HighscoreScreenPreview() {
    DadflexTheme {
        HighscoreScreen(
            navController = rememberNavController(),
            modifier = Modifier,
        )
    }
}
