package com.example.travel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.travel.data.manager.AuthPreferences
import com.example.travel.presentation.nav_graph.Route

@Composable
fun LauncherScreen(authPreferences: AuthPreferences, appState: TravelsAppState) {

    val isUserLoggedIn by authPreferences.isUserLoggedIn.collectAsState(initial = false)

    LaunchedEffect(isUserLoggedIn) {
        if (isUserLoggedIn) {
            appState.navigate(Route.HomePage.route)
        } else {
            appState.navigate(Route.SignIn.route)
        }
    }
}