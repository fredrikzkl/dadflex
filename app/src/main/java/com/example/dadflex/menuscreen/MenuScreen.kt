package com.example.dadflex.menuscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dadflex.navigation.Navigation
import com.example.dadflex.navigation.Screen
import com.example.dadflex.ui.theme.DadflexTheme

@Composable
fun MenuScreen(
    modifier: Modifier,
    navController: NavController
){
    var name by remember {
        mutableStateOf("")
    }

    Column (
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        NameInput(modifier, navController)
    }
}

@Composable
fun Header(){
        Text(
            modifier = Modifier.padding(28.dp),
            text = "Dadflex",
            fontSize = 24.sp
        )
}

@Composable
fun NameInput(modifier : Modifier, navController: NavController){
    var name by remember {
        mutableStateOf("")
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = name,
            onValueChange = {text ->
                name = text
            },
            label = { Text("Name") }
        )
        Button(
            modifier = modifier,
            onClick = {
                name = "Start!"
                navController.navigate(Screen.GameScreen.route)
            }
        ){
            Text("Start!")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DadflexTheme {
        MenuScreen(
            modifier = Modifier,
            navController = rememberNavController()
        )
    }
}