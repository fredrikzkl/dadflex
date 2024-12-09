package com.example.dadflex.highscorescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.component.DadButton
import com.example.dadflex.navigation.Screen
import com.example.dadflex.preferences.HighscoreEntry
import com.example.dadflex.preferences.PreferencesHelper
import com.example.dadflex.ui.theme.DadBlue
import com.example.dadflex.ui.theme.DadflexTheme

@Composable
fun HighscoreScreen(
    modifier: Modifier,
    navController: NavController
){
    val context = LocalContext.current

    // Load in highscores
    val highscore = PreferencesHelper.getHighscore(context)
    val highscoreList = highscore.getHighscoreList()

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(DadBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(28.dp),
            fontSize = 24.sp,
            text = "Highscores"
        )
        if(highscoreList.isEmpty()){
            Text(text = "No highscores yet!")
        } else {
            HighscoreList(highscoreList)
        }

        DadButton(
            modifier = modifier.padding(16.dp),
            onButtonClick = {
                navController.navigate(Screen.MenuScreen.route)
            },
            buttonLabel = "Back"
        )
    }
}

@Composable
fun HighscoreList(highscoreList: List<HighscoreEntry>){
    LazyColumn {
        items(highscoreList.size) { index ->
            val highscore = highscoreList[index]
            Row (
                modifier = Modifier
                    .padding(horizontal = 64.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Text(
                    modifier = Modifier.weight(1f),
                    text = highscore.name
                )
                Text(
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    text = highscore.reactionTime.toString() + " ms"
                )
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
