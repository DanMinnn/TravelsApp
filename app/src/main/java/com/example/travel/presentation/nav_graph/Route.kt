package com.example.travel.presentation.nav_graph

sealed class Route(
    val route: String
){
    object Launcher : Route(route = "launcher")
    object SignIn : Route(route = "signIn")
    object SignInEmailScreen : Route(route = "signInEmail")
    object SignUp : Route(route = "signUp")
    object ForgotPassword : Route(route = "forgotPassword")
    object HomePage : Route(route = "homePage")
}
