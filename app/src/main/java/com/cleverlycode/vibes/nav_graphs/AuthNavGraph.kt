package com.cleverlycode.vibes.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cleverlycode.vibes.VibesAppState
import com.cleverlycode.vibes.screens.login.LoginScreen
import com.cleverlycode.vibes.screens.password_recover.PasswordRecoverScreen
import com.cleverlycode.vibes.screens.signup.SignUpScreen

fun NavGraphBuilder.authNavGraph(appState: VibesAppState) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthRoutes.Login.route
    ) {
        composable(route = AuthRoutes.Login.route) {
            LoginScreen(navigate = { route -> appState.navigate(route) })
        }

        composable(route = AuthRoutes.SignUp.route) {
            SignUpScreen(navigateAndPopBackStack = { route -> appState.navigateAndPopBackStack(route) })
        }

        composable(route = AuthRoutes.PasswordRecover.route) {
            PasswordRecoverScreen(navigate = { route -> appState.navigate(route) })
        }
    }
}

sealed class AuthRoutes(val route: String) {
    object Login : AuthRoutes("Login")
    object SignUp : AuthRoutes("SignUp")
    object PasswordRecover : AuthRoutes("PasswordRecover")
}