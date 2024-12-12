package com.example.dadflex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dadflex.navigation.Navigation
import com.example.dadflex.ui.theme.DadflexTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
  DadflexTheme {
         Scaffold(
             modifier = Modifier
                 .fillMaxSize()
         ) { innerPadding ->
             Navigation(modifier = Modifier.padding(innerPadding))
         }
     }
}


@Composable
fun NameInput(){
    var name by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            OutlinedTextField(
                value = name,
                onValueChange = {text ->
                    name = text
                },
                label = { androidx.compose.material3.Text("Name") }
            )
            androidx.compose.material3.Button(
                onClick = {
                    name = ""
                }
            ){
                androidx.compose.material3.Text("Start")
            }

        }
    }
}

@Composable
fun DadFlexButton() {
    var count by remember {
        mutableIntStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        androidx.compose.material3.Text(
            text = count.toString(),
            fontSize = 20.sp,
        )

        androidx.compose.material3.Button(onClick = {
            count++;
        }) {
            androidx.compose.material3.Text(text = "Click me")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        androidx.compose.material3.Text(
            text = "Dadflex",
            color = Color.DarkGray,
            fontSize = 30.sp
        )
        androidx.compose.material3.Text(
            text = "Do you have dad reflex?",
            color = Color.LightGray,
            fontSize = 20.sp
        )
        NameInput()
        DadFlexButton()
    }
}



@Preview
@Composable
fun GreetingPreview() {
    DadflexTheme {
        Greeting("Android")
    }
}