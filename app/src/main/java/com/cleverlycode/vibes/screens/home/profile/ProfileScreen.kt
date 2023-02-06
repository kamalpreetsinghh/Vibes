package com.cleverlycode.vibes.screens.home.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.vibes.composables.CustomButton
import com.cleverlycode.vibes.nav_graphs.AuthRoutes
import com.cleverlycode.vibes.nav_graphs.Graph
import com.cleverlycode.vibes.theme.EndGradient
import com.cleverlycode.vibes.theme.StartGradient

@Composable
fun ProfileScreen(
    navigate: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val navHostController = rememberNavController()
//    val navGraph = navHostController.setGraph(authNavGraph(), AuthRoutes.Login)
    Box(
        modifier = Modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(StartGradient, EndGradient),
                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(
                label = "Logout",
                onClick = { viewModel.signOut(navigate = { route -> navHostController.navigate(route) }) }
            )
        }
    }
}
