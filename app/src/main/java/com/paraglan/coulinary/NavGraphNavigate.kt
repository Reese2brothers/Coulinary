package com.paraglan.coulinary

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paraglan.coulinary.screens.MainScreen
import com.paraglan.coulinary.screens.VideoScreen
import com.paraglan.coulinary.screens.ones.eight.EightRecipeScreen
import com.paraglan.coulinary.screens.ones.eight.EightScreen
import com.paraglan.coulinary.screens.ones.five.FiveRecipeScreen
import com.paraglan.coulinary.screens.ones.five.FiveScreen
import com.paraglan.coulinary.screens.ones.four.FourRecipeScreen
import com.paraglan.coulinary.screens.ones.four.FourScreen
import com.paraglan.coulinary.screens.ones.nine.NineRecipeScreen
import com.paraglan.coulinary.screens.ones.nine.NineScreen
import com.paraglan.coulinary.screens.ones.one.OneRecipeScreen
import com.paraglan.coulinary.screens.ones.one.OneScreen
import com.paraglan.coulinary.screens.ones.seven.SevenRecipeScreen
import com.paraglan.coulinary.screens.ones.seven.SevenScreen
import com.paraglan.coulinary.screens.ones.six.SixRecipeScreen
import com.paraglan.coulinary.screens.ones.six.SixScreen
import com.paraglan.coulinary.screens.ones.ten.TenRecipeScreen
import com.paraglan.coulinary.screens.ones.ten.TenScreen
import com.paraglan.coulinary.screens.ones.three.ThreeRecipeScreen
import com.paraglan.coulinary.screens.ones.three.ThreeScreen
import com.paraglan.coulinary.screens.ones.two.TwoRecipeScreen
import com.paraglan.coulinary.screens.ones.two.TwoScreen
import com.paraglan.coulinary.screens.twos.eleven.ElevenRecipeScreen
import com.paraglan.coulinary.screens.twos.eleven.ElevenScreen
import com.paraglan.coulinary.screens.twos.fifteen.FifteenRecipeScreen
import com.paraglan.coulinary.screens.twos.fifteen.FifteenScreen
import com.paraglan.coulinary.screens.twos.fourteen.FourteenRecipeScreen
import com.paraglan.coulinary.screens.twos.fourteen.FourteenScreen
import com.paraglan.coulinary.screens.twos.sixteen.SixteenRecipeScreen
import com.paraglan.coulinary.screens.twos.sixteen.SixteenScreen
import com.paraglan.coulinary.screens.twos.thirteen.ThirteenRecipeScreen
import com.paraglan.coulinary.screens.twos.thirteen.ThirteenScreen
import com.paraglan.coulinary.screens.twos.twelve.TwelveRecipeScreen
import com.paraglan.coulinary.screens.twos.twelve.TwelveScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun NavGraphNavigate(context : Context, navController: NavHostController) {
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") { MainScreen(navController = navController) }
        composable("OneScreen") { OneScreen(navController = navController) }
        composable("TwoScreen") { TwoScreen(navController = navController) }
        composable("ThreeScreen") { ThreeScreen(navController = navController)}
        composable("FourScreen") { FourScreen(navController = navController)}
        composable("FiveScreen") { FiveScreen(navController = navController)}
        composable("SixScreen") { SixScreen(navController = navController)}
        composable("SevenScreen") { SevenScreen(navController = navController)}
        composable("EightScreen") { EightScreen(navController = navController)}
        composable("NineScreen") { NineScreen(navController = navController)}
        composable("TenScreen") { TenScreen(navController = navController)}
        composable("ElevenScreen") { ElevenScreen(navController = navController)}
        composable("TwelveScreen") { TwelveScreen(navController = navController)}
        composable("ThirteenScreen") { ThirteenScreen(navController = navController)}
        composable("FourteenScreen") { FourteenScreen(navController = navController)}
        composable("FifteenScreen") { FifteenScreen(navController = navController)}
        composable("SixteenScreen") { SixteenScreen(navController = navController)}


        composable(route = "OneRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
        composable(route = "TwoRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            TwoRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThreeRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            ThreeRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            FourRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiveRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            FiveRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "SixRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            SixRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "SevenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            SevenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "EightRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            EightRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "NineRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            NineRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            TenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ElevenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            ElevenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwelveRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            TwelveRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirteenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            ThirteenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourteenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            FourteenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FifteenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            FifteenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "SixteenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("video") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType }
            )) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image") ?: "", StandardCharsets.UTF_8.toString())
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            SixteenRecipeScreen(navController, title, content, image, video, id)
        }




        composable(route = "VideoScreen/{video}/{title}/{id}/{key}",
            arguments = listOf(
                navArgument("video") { type = NavType.StringType },
                navArgument("title") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType },
                navArgument("key") { type = NavType.StringType }
            )) { backStackEntry ->
            val video = URLDecoder.decode(backStackEntry.arguments?.getString("video") ?: "", StandardCharsets.UTF_8.toString())
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            val key = backStackEntry.arguments?.getString("key") ?: ""
            VideoScreen(navController, video, title, id, key)
        }
    }
}