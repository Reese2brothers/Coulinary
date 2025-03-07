package com.paraglan.coulinary

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paraglan.coulinary.screens.MainScreen
import com.paraglan.coulinary.screens.one.OneRecipeScreen
import com.paraglan.coulinary.screens.one.OneScreen
import com.paraglan.coulinary.screens.two.TwoScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun NavGraphNavigate(context : Context, navController: NavHostController) {
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(navController = navController)
        }
        composable("OneScreen") {
            OneScreen(navController = navController)
        }
        composable("TwoScreen") {
            TwoScreen()
        }
        composable(
            route = "OneRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            OneRecipeScreen(navController, title, content, image, video, id)
        }
    }
}