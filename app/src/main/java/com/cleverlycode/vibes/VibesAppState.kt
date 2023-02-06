package com.cleverlycode.vibes

import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController

@Stable
class VibesAppState(
    var navController: NavHostController,
) {
    fun navigate(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateAndPopUp(route: String, popUp: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) { inclusive = true }
        }
    }

    fun navigateAndPopBackStack(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
            navController.popBackStack()
        }
    }

    fun clearAndNavigate(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    }
}