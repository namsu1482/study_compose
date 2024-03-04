package com.example.myplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun ThirdScreen(navController: NavController) {
    Text("Third Screen")
}

@Composable
fun ThirdDetailScreen(navController: NavController){
    Column {
        Text("Third Detail Screen")
    }
}