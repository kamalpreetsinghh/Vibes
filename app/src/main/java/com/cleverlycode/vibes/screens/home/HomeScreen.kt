package com.cleverlycode.vibes.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.vibes.VibesAppState
import com.cleverlycode.vibes.nav_graphs.HomeNavGraph
import com.cleverlycode.vibes.screens.home.bottom_navbar.BottomNavBar
import com.cleverlycode.vibes.screens.home.bottom_navbar.BottomNavItem

@Composable
fun HomeScreen(appState: VibesAppState) {
    val navbarItems = listOf(
        BottomNavItem.Post,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = {
            BottomNavBar(
                items = navbarItems,
                backStackEntry = appState.navController.currentBackStackEntryAsState()
            ) {
                appState.navigate(it.route)
            }
        }
    ) {
        HomeNavGraph(appState)
    }
}

