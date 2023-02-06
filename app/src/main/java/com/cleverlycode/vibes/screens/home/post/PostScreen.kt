package com.cleverlycode.vibes.screens.home.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cleverlycode.vibes.screens.home.profile.ProfileViewModel
import com.cleverlycode.vibes.theme.EndGradient
import com.cleverlycode.vibes.theme.StartGradient

@Composable
fun PostScreen(
    navigate: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
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
            Text(text = "POST SCREEN")
        }
    }
}