package com.example.dadflex.component

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dadflex.navigation.Screen
import com.example.dadflex.preferences.PreferencesHelper
import com.example.dadflex.ui.theme.DadflexTheme

@Composable
fun NameInput(
    navController: NavController
) {
    val context = LocalContext.current

    var name by remember {
        mutableStateOf("")
    }

    Column (modifier = Modifier
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text("Enter your name")
        OutlinedTextField(
            value = name,
            onValueChange = {text ->
                name = text
            },
            label = { Text("Name") }
        )
        DadButton(
            modifier = Modifier.padding(top = 16.dp),
            onButtonClick = {
                if (name.isNotEmpty()) {
                    PreferencesHelper.saveName(context, name);
                    navController.navigate(Screen.MenuScreen.route)
                }
            },
            buttonLabel = "Save"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NameInputPreview() {
    DadflexTheme {
        NameInput(navController = NavController(LocalContext.current))
    }
}

