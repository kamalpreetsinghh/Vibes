package com.cleverlycode.vibes.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.vibes.VibesAppState
import com.cleverlycode.vibes.data.service.impl.AccountServiceImpl
import com.cleverlycode.vibes.screens.home.HomeScreen

@Composable
fun RootNavigationGraph(appState: VibesAppState) {
    val accountService = AccountServiceImpl()   // Use dependency injection
    val startDestination =
        if (accountService.isUserAuthenticatedInFirebase()) Graph.HOME else Graph.AUTHENTICATION

    NavHost(
        navController = appState.navController,
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        authNavGraph(appState = appState)
        composable(route = Graph.HOME) {
            appState.navController = rememberNavController()
            HomeScreen(appState)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
}