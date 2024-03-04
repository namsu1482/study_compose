package com.example.myplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myplayground.ui.theme.MyPlayGroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPlayGroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun BottomNav(navController: NavController) {
    val navigationSelectedItem = remember { mutableStateOf(0) }

    NavigationBar {
        bottomNavList.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(selected = index == navigationSelectedItem.value,
                onClick = {
                    navigationSelectedItem.value = index
                    navController.navigate(bottomNavItem.route) {

                        launchSingleTop = true
                        restoreState = true
                    }

                },
                icon = {
                    Icon(
                        imageVector = bottomNavItem.icon,
                        contentDescription = bottomNavItem.label
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNav(navController) }) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.homeScreen.route,
            modifier = Modifier.padding(it)
        ) {
            homeScreenGraph(navController,BottomNavItem.homeScreen.route)

            composable(BottomNavItem.secondScreen.route) {
                SecondScreen(navController)
            }
            composable(BottomNavItem.thirdScreen.route) {
                ThirdScreen(navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPlayGroundTheme {
    }
}