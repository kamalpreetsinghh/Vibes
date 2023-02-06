package com.cleverlycode.vibes.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.cleverlycode.vibes.theme.EndGradient
import com.cleverlycode.vibes.theme.StartGradient

@Composable
fun AppBackground(
    modifier: Modifier = Modifier,
    content: @Composable() (BoxScope.() -> Unit)
) {
    Box(
        modifier = modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(StartGradient, EndGradient),
                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        )
    ) {
        content
    }
}