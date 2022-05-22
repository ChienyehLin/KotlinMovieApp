package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation() {

    //Navi Host包含了 很多歌Navi graph节点
    // Composable function就是Navi graph node
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreen.HomeScreen.name
    ) {
        composable(MovieScreen.HomeScreen.name) {
            //here we pass where this should lead us to
            //初始画面
            HomeScreen(navController = navController)
        }

        //www.google.com/details-screen/id=34?
        //append data to the end of the route {}里面放的是variable name,默认是String类型
        //arguments传了一个list, list里面的放的是每个variable的类型，默认是String，这里我们手动指定movie变数的类型是String
        composable(MovieScreen.DetailScreen.name + "/{movie}",

            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) {
            backStackEntry->//传递的数据在back stack entry里面
            //here we pass where this should lead us to
            //初始画面
            DetailsScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
        }
    }

}