package com.paraglan.coulinary

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paraglan.coulinary.screens.MainScreen
import com.paraglan.coulinary.screens.one.OneScreen
import com.paraglan.coulinary.screens.two.TwoScreen

@Composable
fun NavGraphNavigate(context : Context, navController: NavHostController) {
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(navController = navController)
        }
        composable("OneScreen") {
            OneScreen()
        }
        composable("TwoScreen") {
            TwoScreen()
        }
//        composable(route = "DetailsScreen/{title}/{content}",
//            arguments = listOf(
//                navArgument("title") { type = NavType.StringType },
//                navArgument("content") { type = NavType.StringType })
//        ) {
//            backStackEntry ->
//            val title = backStackEntry.arguments?.getString("title") ?: ""
//            val content = backStackEntry.arguments?.getString("content") ?: ""
//            DetailsScreen(navController, title, content)
//        }
    }
}