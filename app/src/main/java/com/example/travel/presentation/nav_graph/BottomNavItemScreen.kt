package com.example.travel.presentation.nav_graph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import com.example.travel.R

sealed class BottomNavItemScreen(val route: String, val icon: Int, val title: String){

    data object Home: BottomNavItemScreen(
        route = "home_screen",
        icon = R.drawable.home,
        title = "Home"
    )

    data object Search: BottomNavItemScreen(
        route = "search_screen",
        icon = R.drawable.search,
        title = "Search"
    )

    data object Trip: BottomNavItemScreen(
        route = "trip_screen",
        icon = R.drawable.trip,
        title = "Trips"
    )

    data object Review: BottomNavItemScreen(
        route = "review_screen",
        icon = R.drawable.review,
        title = "Review"
    )

    data object Account: BottomNavItemScreen(
        route = "account_screen",
        icon = R.drawable.account,
        title = "Account"
    )
}
