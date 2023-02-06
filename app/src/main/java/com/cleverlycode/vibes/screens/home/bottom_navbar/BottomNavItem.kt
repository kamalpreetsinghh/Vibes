package com.cleverlycode.vibes.screens.home.bottom_navbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
) {
    object Post : BottomNavItem(
        name = "POST",
        route = "POST",
        icon = Icons.Default.Home
    )

    object Profile : BottomNavItem(
        name = "PROFILE",
        route = "PROFILE",
        icon = Icons.Default.Person
    )
}
