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
import com.paraglan.coulinary.screens.fives.fifty.FiftyRecipeScreen
import com.paraglan.coulinary.screens.fives.fifty.FiftyScreen
import com.paraglan.coulinary.screens.fives.fourtyeight.FourtyEightRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtyeight.FourtyEightScreen
import com.paraglan.coulinary.screens.fives.fourtyfive.FourtyFiveRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtyfive.FourtyFiveScreen
import com.paraglan.coulinary.screens.fives.fourtyfour.FourtyFourRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtyfour.FourtyFourScreen
import com.paraglan.coulinary.screens.fives.fourtynine.FourtyNineRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtynine.FourtyNineScreen
import com.paraglan.coulinary.screens.fives.fourtyone.FourtyOneRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtyone.FourtyOneScreen
import com.paraglan.coulinary.screens.fives.fourtyseven.FourtySevenRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtyseven.FourtySevenScreen
import com.paraglan.coulinary.screens.fives.fourtysix.FourtySixRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtysix.FourtySixScreen
import com.paraglan.coulinary.screens.fives.fourtythree.FourtyThreeRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtythree.FourtyThreeScreen
import com.paraglan.coulinary.screens.fives.fourtytwo.FourtyTwoRecipeScreen
import com.paraglan.coulinary.screens.fives.fourtytwo.FourtyTwoScreen
import com.paraglan.coulinary.screens.fours.fourty.FourtyRecipeScreen
import com.paraglan.coulinary.screens.fours.fourty.FourtyScreen
import com.paraglan.coulinary.screens.fours.thirtyeight.ThirtyEightRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtyeight.ThirtyEightScreen
import com.paraglan.coulinary.screens.fours.thirtyfive.ThirtyFiveRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtyfive.ThirtyFiveScreen
import com.paraglan.coulinary.screens.fours.thirtyfour.ThirtyFourRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtyfour.ThirtyFourScreen
import com.paraglan.coulinary.screens.fours.thirtynine.ThirtyNineRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtynine.ThirtyNineScreen
import com.paraglan.coulinary.screens.fours.thirtyone.ThirtyOneRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtyone.ThirtyOneScreen
import com.paraglan.coulinary.screens.fours.thirtyseven.ThirtySevenRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtyseven.ThirtySevenScreen
import com.paraglan.coulinary.screens.fours.thirtysix.ThirtySixRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtysix.ThirtySixScreen
import com.paraglan.coulinary.screens.fours.thirtythree.ThirtyThreeRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtythree.ThirtyThreeScreen
import com.paraglan.coulinary.screens.fours.thirtytwo.ThirtyTwoRecipeScreen
import com.paraglan.coulinary.screens.fours.thirtytwo.ThirtyTwoScreen
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
import com.paraglan.coulinary.screens.sixs.fiftyeight.FiftyEightRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftyeight.FiftyEightScreen
import com.paraglan.coulinary.screens.sixs.fiftyfive.FiftyFiveRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftyfive.FiftyFiveScreen
import com.paraglan.coulinary.screens.sixs.fiftyfour.FiftyFourRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftyfour.FiftyFourScreen
import com.paraglan.coulinary.screens.sixs.fiftynine.FiftyNineRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftynine.FiftyNineScreen
import com.paraglan.coulinary.screens.sixs.fiftyone.FiftyOneRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftyone.FiftyOneScreen
import com.paraglan.coulinary.screens.sixs.fiftyseven.FiftySevenRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftyseven.FiftySevenScreen
import com.paraglan.coulinary.screens.sixs.fiftysix.FiftySixRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftysix.FiftySixScreen
import com.paraglan.coulinary.screens.sixs.fiftythree.FiftyThreeRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftythree.FiftyThreeScreen
import com.paraglan.coulinary.screens.sixs.fiftytwo.FiftyTwoRecipeScreen
import com.paraglan.coulinary.screens.sixs.fiftytwo.FiftyTwoScreen
import com.paraglan.coulinary.screens.sixs.sixty.SixtyRecipeScreen
import com.paraglan.coulinary.screens.sixs.sixty.SixtyScreen
import com.paraglan.coulinary.screens.threes.thirty.ThirtyRecipeScreen
import com.paraglan.coulinary.screens.threes.thirty.ThirtyScreen
import com.paraglan.coulinary.screens.threes.twentyeight.TwentyEightRecipeScreen
import com.paraglan.coulinary.screens.threes.twentyeight.TwentyEightScreen
import com.paraglan.coulinary.screens.threes.twentyfive.TwentyFiveRecipeScreen
import com.paraglan.coulinary.screens.threes.twentyfive.TwentyFiveScreen
import com.paraglan.coulinary.screens.threes.twentyfour.TwentyFourRecipeScreen
import com.paraglan.coulinary.screens.threes.twentyfour.TwentyFourScreen
import com.paraglan.coulinary.screens.threes.twentynine.TwentyNineRecipeScreen
import com.paraglan.coulinary.screens.threes.twentynine.TwentyNineScreen
import com.paraglan.coulinary.screens.twos.eightteen.EighteenRecipeScreen
import com.paraglan.coulinary.screens.twos.eightteen.EighteenScreen
import com.paraglan.coulinary.screens.twos.eleven.ElevenRecipeScreen
import com.paraglan.coulinary.screens.twos.eleven.ElevenScreen
import com.paraglan.coulinary.screens.twos.fifteen.FifteenRecipeScreen
import com.paraglan.coulinary.screens.twos.fifteen.FifteenScreen
import com.paraglan.coulinary.screens.twos.fourteen.FourteenRecipeScreen
import com.paraglan.coulinary.screens.twos.fourteen.FourteenScreen
import com.paraglan.coulinary.screens.twos.nineteen.NineteenRecipeScreen
import com.paraglan.coulinary.screens.twos.nineteen.NineteenScreen
import com.paraglan.coulinary.screens.twos.seventeen.SeventeenRecipeScreen
import com.paraglan.coulinary.screens.twos.seventeen.SeventeenScreen
import com.paraglan.coulinary.screens.twos.sixteen.SixteenRecipeScreen
import com.paraglan.coulinary.screens.twos.sixteen.SixteenScreen
import com.paraglan.coulinary.screens.twos.thirteen.ThirteenRecipeScreen
import com.paraglan.coulinary.screens.twos.thirteen.ThirteenScreen
import com.paraglan.coulinary.screens.twos.twelve.TwelveRecipeScreen
import com.paraglan.coulinary.screens.twos.twelve.TwelveScreen
import com.paraglan.coulinary.screens.twos.twenty.TwentyRecipeScreen
import com.paraglan.coulinary.screens.threes.twentyone.TwentyOneRecipeScreen
import com.paraglan.coulinary.screens.threes.twentytwo.TwentyTwoRecipeScreen
import com.paraglan.coulinary.screens.threes.twentythree.TwentyThreeRecipeScreen
import com.paraglan.coulinary.screens.twos.twenty.TwentyScreen
import com.paraglan.coulinary.screens.threes.twentyone.TwentyOneScreen
import com.paraglan.coulinary.screens.threes.twentyseven.TwentySevenRecipeScreen
import com.paraglan.coulinary.screens.threes.twentyseven.TwentySevenScreen
import com.paraglan.coulinary.screens.threes.twentysix.TwentySixRecipeScreen
import com.paraglan.coulinary.screens.threes.twentysix.TwentySixScreen
import com.paraglan.coulinary.screens.threes.twentytwo.TwentyTwoScreen
import com.paraglan.coulinary.screens.threes.twentythree.TwentyThreeScreen
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
        composable("SeventeenScreen") { SeventeenScreen(navController = navController)}
        composable("EighteenScreen") { EighteenScreen(navController = navController)}
        composable("NineteenScreen") { NineteenScreen(navController = navController)}
        composable("TwentyScreen") { TwentyScreen(navController = navController)}
        composable("TwentyOneScreen") { TwentyOneScreen(navController = navController)}
        composable("TwentyTwoScreen") { TwentyTwoScreen(navController = navController)}
        composable("TwentyThreeScreen") { TwentyThreeScreen(navController = navController)}
        composable("TwentyFourScreen") { TwentyFourScreen(navController = navController)}
        composable("TwentyFiveScreen") { TwentyFiveScreen(navController = navController)}
        composable("TwentySixScreen") { TwentySixScreen(navController = navController)}
        composable("TwentySevenScreen") { TwentySevenScreen(navController = navController)}
        composable("TwentyEightScreen") { TwentyEightScreen(navController = navController)}
        composable("TwentyNineScreen") { TwentyNineScreen(navController = navController)}
        composable("ThirtyScreen") { ThirtyScreen(navController = navController)}
        composable("ThirtyOneScreen") { ThirtyOneScreen(navController = navController)}
        composable("ThirtyTwoScreen") { ThirtyTwoScreen(navController = navController)}
        composable("ThirtyThreeScreen") { ThirtyThreeScreen(navController = navController)}
        composable("ThirtyFourScreen") { ThirtyFourScreen(navController = navController)}
        composable("ThirtyFiveScreen") { ThirtyFiveScreen(navController = navController)}
        composable("ThirtySixScreen") { ThirtySixScreen(navController = navController)}
        composable("ThirtySevenScreen") { ThirtySevenScreen(navController = navController)}
        composable("ThirtyEightScreen") { ThirtyEightScreen(navController = navController)}
        composable("ThirtyNineScreen") { ThirtyNineScreen(navController = navController)}
        composable("FourtyScreen") { FourtyScreen(navController = navController)}
        composable("FourtyOneScreen") { FourtyOneScreen(navController = navController)}
        composable("FourtyTwoScreen") { FourtyTwoScreen(navController = navController)}
        composable("FourtyThreeScreen") { FourtyThreeScreen(navController = navController)}
        composable("FourtyFourScreen") { FourtyFourScreen(navController = navController)}
        composable("FourtyFiveScreen") { FourtyFiveScreen(navController = navController)}
        composable("FourtySixScreen") { FourtySixScreen(navController = navController)}
        composable("FourtySevenScreen") { FourtySevenScreen(navController = navController)}
        composable("FourtyEightScreen") { FourtyEightScreen(navController = navController)}
        composable("FourtyNineScreen") { FourtyNineScreen(navController = navController)}
        composable("FiftyScreen") { FiftyScreen(navController = navController)}
        composable("FiftyOneScreen") { FiftyOneScreen(navController = navController)}
        composable("FiftyTwoScreen") { FiftyTwoScreen(navController = navController)}
        composable("FiftyThreeScreen") { FiftyThreeScreen(navController = navController)}
        composable("FiftyFourScreen") { FiftyFourScreen(navController = navController)}
        composable("FiftyFiveScreen") { FiftyFiveScreen(navController = navController)}
        composable("FiftySixScreen") { FiftySixScreen(navController = navController)}
        composable("FiftySevenScreen") { FiftySevenScreen(navController = navController)}
        composable("FiftyEightScreen") { FiftyEightScreen(navController = navController)}
        composable("FiftyNineScreen") { FiftyNineScreen(navController = navController)}
        composable("SixtyScreen") { SixtyScreen(navController = navController)}


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
        composable(route = "SeventeenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            SeventeenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "EighteenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            EighteenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "NineteenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            NineteenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyOneRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyOneRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyTwoRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyTwoRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyThreeRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyThreeRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyFourRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyFourRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyFiveRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyFiveRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentySixRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentySixRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentySevenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentySevenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyEightRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyEightRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "TwentyNineRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            TwentyNineRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyOneRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyOneRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyTwoRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyTwoRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyThreeRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyThreeRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyFourRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyFourRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyFiveRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyFiveRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtySixRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtySixRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtySevenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtySevenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyEightRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyEightRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "ThirtyNineRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            ThirtyNineRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyOneRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyOneRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyTwoRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyTwoRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyThreeRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyThreeRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyFourRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyFourRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyFiveRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyFiveRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtySixRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtySixRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtySevenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtySevenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyEightRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyEightRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FourtyNineRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FourtyNineRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyOneRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyOneRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyTwoRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyTwoRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyThreeRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyThreeRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyFourRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyFourRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyFiveRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyFiveRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftySixRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftySixRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftySevenRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftySevenRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyEightRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyEightRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "FiftyNineRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            FiftyNineRecipeScreen(navController, title, content, image, video, id)
        }
        composable(route = "SixtyRecipeScreen/{title}/{content}/{image}/{video}/{id}",
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
            SixtyRecipeScreen(navController, title, content, image, video, id)
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