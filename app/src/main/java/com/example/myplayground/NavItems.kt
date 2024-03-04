package com.example.myplayground

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object homeScreen : BottomNavItem("home", Icons.Default.Home, "Home")
    object secondScreen : BottomNavItem("second", Icons.Default.Search, "second")
    object thirdScreen : BottomNavItem("third", Icons.Default.Person, "third")
}

val bottomNavList =
    listOf(BottomNavItem.homeScreen, BottomNavItem.secondScreen, BottomNavItem.thirdScreen)

sealed interface ScreenRoute{
    val route:String
}
