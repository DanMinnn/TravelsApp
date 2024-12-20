package com.example.travel

import androidx.compose.runtime.Stable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.travel.data.manager.AuthPreferences

@Stable
class TravelsAppState(val navController: NavHostController, val authPreferences: AuthPreferences) {

    fun popUp(){
        navController.popBackStack()
    }

    fun navigate(route: String){
        navController.navigate(route){
            launchSingleTop = true
        }
    }

    fun navigateAndPopUp(route: String, popUp: String){
        navController.navigate(route){
            launchSingleTop = true
            popUpTo(popUp){
                inclusive = true
            }
        }
    }

    fun clearAndNavigate(route: String){
        navController.navigate(route){
            launchSingleTop = true
            popUpTo(0){
                inclusive = true
            }
        }
    }
}