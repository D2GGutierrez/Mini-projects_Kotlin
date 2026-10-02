package com.gutierrez.navlab.config

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gutierrez.navlab.screens.*

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route){
            HomeScreen(navController)
        }

        composable(Screen.List.route){
            ListScreen(navController)
        }

        composable(Screen.Detail.route){
            DetailScreen(navController)
        }
    }
}