package com.example.travel.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travel.presentation.sign_in_screen.ForgotPassword
import com.example.travel.presentation.sign_in_screen.SignIn
import com.example.travel.presentation.sign_in_screen.SignInEmail
import com.example.travel.presentation.sign_in_screen.SignUp

@Composable
fun NavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.SignIn.route, builder = {
        composable(Route.SignIn.route){
            SignIn(navController)
        }
        composable(Route.SignInEmailScreen.route){
            SignInEmail(navController)
        }
        composable(Route.SignUp.route){
            SignUp(navController)
        }

        composable(Route.ForgotPassword.route){
            ForgotPassword(navController)
        }
    })
}