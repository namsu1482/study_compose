package com.example.myplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.navigation

sealed interface HomeScreen : ScreenRoute {
    object HomeMain : HomeScreen {
        override val route: String = "HomeMain"
    }

    object HomeDetail : HomeScreen {
        const val baseRoute = "HomeDetail"
        const val navArgNameUserId = "userId"
        override val route: String = "$baseRoute/{$navArgNameUserId}"
        val args = listOf(navArgument(navArgNameUserId){type = NavType.StringType})
        fun getRoute(userId: String): String {
            return "$baseRoute/$userId"
        }
    }

}
//
//sealed class HomeScreen(val route: String){
//    object HomeMain:HomeScreen("HomeMain")
//    data class HomeDetail(val baseRoute:String = "HomeDetail",val argName:String = "userId"):HomeScreen("${baseRoute}/{$argName}")
//}

@Composable
fun HomeScreen(navController: NavController, onNaviToDetailClicked: () -> Unit) {
    Column {
        Text("Home Screen")
        Button(onClick = { onNaviToDetailClicked() }) {
            Text("go to Detail")
        }
    }
}

@Composable
fun HomeDetailScreen(navController: NavController, useId: String) {
    Column {
        Text("Home Detail Screen")
        Text(useId)
    }
}

fun NavGraphBuilder.homeScreenGraph(navController: NavController, route: String) {
    navigation(
        startDestination = HomeScreen.HomeMain.route,
        route = route
    ) {
        composable(HomeScreen.HomeMain.route) {
            HomeScreen(navController = navController) {
                navController.navigate(HomeScreen.HomeDetail.getRoute("namsu1482"))
            }
        }
        composable(
            HomeScreen.HomeDetail.route,
            arguments = HomeScreen.HomeDetail.args
        ) {
            val userId = it.arguments?.getString(HomeScreen.HomeDetail.navArgNameUserId) ?: "NONE"
            HomeDetailScreen(navController = navController, userId)

        }
    }
}