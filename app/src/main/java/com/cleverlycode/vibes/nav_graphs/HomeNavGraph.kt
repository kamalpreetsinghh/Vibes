package com.cleverlycode.vibes.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.vibes.VibesAppState
import com.cleverlycode.vibes.screens.home.bottom_navbar.BottomNavItem
import com.cleverlycode.vibes.screens.home.post.PostScreen
import com.cleverlycode.vibes.screens.home.profile.ProfileScreen
import com.cleverlycode.vibes.screens.login.LoginScreen

@Composable
fun HomeNavGraph(appState: VibesAppState) {
    NavHost(
        navController = appState.navController,
        route = Graph.HOME,
        startDestination = BottomNavItem.Post.route
    ) {
        homeNavGraph(appState)
    }
}

fun NavGraphBuilder.homeNavGraph(appState: VibesAppState) {
    composable(route = BottomNavItem.Post.route) {
        PostScreen(navigate = { route -> appState.navigate(route) })
    }

    composable(route = BottomNavItem.Profile.route) {
        ProfileScreen(navigate = { route -> appState.navigate(route) })
    }
}