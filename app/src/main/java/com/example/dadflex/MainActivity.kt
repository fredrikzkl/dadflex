package com.example.dadflex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dadflex.navigation.Navigation
import com.example.dadflex.ui.theme.DadflexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DadflexTheme {
                Scaffold(
                    modifier = Modifier
                                .fillMaxSize()
                    ) { innerPadding ->
                    Navigation(modifier = Modifier.padding(innerPadding))
                }
            }
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
                label = { Text("Name") }
            )
            Button(
                onClick = {
                    name = ""
                }
            ){
                Text("Start")
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
        Text(
            text = count.toString(),
            fontSize = 20.sp,
        )

        Button(onClick = {
            count++;
        }) {
            Text(text = "Click me")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Dadflex",
            color = Color.DarkGray,
            fontSize = 30.sp
        )
        Text(
            text = "Do you have dad reflex?",
            color = Color.LightGray,
            fontSize = 20.sp
        )
        NameInput()
        DadFlexButton()
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DadflexTheme {
        Greeting("Android")

    }
}