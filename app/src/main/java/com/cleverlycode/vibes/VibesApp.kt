package com.cleverlycode.vibes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.vibes.nav_graphs.RootNavigationGraph
import com.cleverlycode.vibes.theme.VibesTheme

@Composable
fun VibesApp() {
    VibesTheme {
        RootNavigationGraph(appState = rememberAppState())
    }
}

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    VibesAppState(navController = navController)
}