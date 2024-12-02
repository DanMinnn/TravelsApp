package com.example.travel.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travel.R
import com.example.travel.presentation.main_screen.account_screen.AccountScreen
import com.example.travel.presentation.main_screen.hom_screen.HomeScreen
import com.example.travel.presentation.main_screen.search_screen.SearchScreen
import com.example.travel.presentation.main_screen.trip_screen.TripScreen
import com.example.travel.presentation.nav_graph.BottomNavItemScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    openAndPopUp: (String, String) -> Unit
) {
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    val bottomNavigationItems = listOf(
        BottomNavItemScreen.Home,
        BottomNavItemScreen.Search,
        BottomNavItemScreen.Trip,
        BottomNavItemScreen.Review,
        BottomNavItemScreen.Account,
    )

    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            Column {
                Divider(
                    color = colorResource(R.color.color_divider),
                    thickness = 1.dp // Độ dày của đường viền
                )
                NavigationBar(
                    containerColor = Color.White,
                    tonalElevation = 8.dp
                ) {
                    bottomNavigationItems.forEachIndexed { index, bottomNavItemScreen ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedTextColor = Color.Black,
                                selectedIconColor = Color.Black,
                                unselectedTextColor = Color.Gray,
                                unselectedIconColor = Color.Gray,
                                indicatorColor = Color.Transparent
                            ),
                            selected = index == navigationSelectedItem,
                            icon = {
                                Icon(
                                    painter = painterResource(id = bottomNavItemScreen.icon),
                                    contentDescription = "Icon Bottom Nav"
                                )
                            },
                            label = {
                                Text(
                                    text = bottomNavItemScreen.title,
                                    //fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Black
                                )
                            },
                            alwaysShowLabel = index == navigationSelectedItem,
                            onClick = {
                                navigationSelectedItem = index
                                navController.navigate(bottomNavItemScreen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues = paddingValues),
            navController = navController,
            startDestination = BottomNavItemScreen.Home.route
        ) {

            composable(route = BottomNavItemScreen.Home.route) {
                HomeScreen()
            }

            composable(route = BottomNavItemScreen.Search.route) {
                SearchScreen()
            }

            composable(route = BottomNavItemScreen.Trip.route) {
                TripScreen()
            }

            composable(route = BottomNavItemScreen.Account.route) {
                AccountScreen()
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainScreenPreview() {
    MainScreen(openAndPopUp = { route, popUp -> })
}