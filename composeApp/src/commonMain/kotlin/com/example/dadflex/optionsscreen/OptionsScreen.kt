package com.example.dadflex.optionsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.dadflex.component.DadButton
import com.example.dadflex.component.DadflexHeader
import com.example.dadflex.component.NameInput
import com.example.dadflex.ui.theme.DadBlue

@Composable
fun OptionsScreen(
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
        NameInput(navController)
        if(navController.currentBackStackEntry != null){
            DadButton(
                modifier = modifier,
                onButtonClick = {
                    navController.navigateUp()
                },
                buttonLabel = "Back"
            )
        }

    }
}