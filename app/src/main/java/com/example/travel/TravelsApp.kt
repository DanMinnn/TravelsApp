package com.example.travel

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travel.presentation.HomePage
import com.example.travel.presentation.nav_graph.Route
import com.example.travel.presentation.sign_in_screen.forgot_password.ForgotPassword
import com.example.travel.presentation.sign_in_screen.SignIn
import com.example.travel.presentation.sign_in_screen.SignInEmail
import com.example.travel.presentation.sign_up.SignUp
import com.example.travel.ui.theme.TravelTheme

@Composable
fun TravelsApp() {
    TravelTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val appState = rememberAppState()

            Scaffold { innerPaddingModifier ->
                NavHost(
                    navController = appState.navController,
                    startDestination = Route.SignIn.route,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {
                    travelsGraph(appState)
                }

            }
        }
    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        TravelsAppState(navController)
    }

fun NavGraphBuilder.travelsGraph(appState: TravelsAppState) {
    composable(Route.SignIn.route) {
        SignIn(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(Route.SignInEmailScreen.route){
        SignInEmail(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp)})
    }

    composable(Route.SignUp.route){
        SignUp(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp)})
    }

    composable(Route.ForgotPassword.route){
        ForgotPassword(openAndPopUp = {route, popUp -> appState.navigateAndPopUp(route, popUp)})
    }

    composable(Route.HomePage.route){
        HomePage(openAndPopUp = {route, popUp -> appState.navigateAndPopUp(route, popUp)} )
    }

}
