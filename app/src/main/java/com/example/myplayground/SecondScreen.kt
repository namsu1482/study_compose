package com.example.myplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun SecondScreen(navController: NavController) {
    Column() {
        Text("Second Screen")
        Button(onClick = {
            navController.navigate("${BottomNavItem.homeScreen.route}/namsu1482")
        }) {
            Text("go to First Screen")
        }
    }
}

@Composable
fun SecondDetailScreen(navController: NavController){
    Column {
        Text("Second Detail Screen")
    }
}