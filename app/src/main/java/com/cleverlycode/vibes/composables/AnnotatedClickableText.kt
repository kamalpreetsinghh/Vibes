package com.cleverlycode.vibes.composables

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.cleverlycode.vibes.theme.Blue

@Composable
fun AnnotatedClickableText(
    text: String,
    clickableText: String,
    route: String,
    navigate: (String) -> Unit
) {
    val annotatedString = buildAnnotatedString {
        append(text)

        pushStringAnnotation(tag = "URL", annotation = route)
        withStyle(
            style = SpanStyle(
                color = Blue,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(clickableText)
        }

        pop()
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = "URL", start = offset,
                end = offset
            )
                .firstOrNull()?.let {
                    navigate(route)
                }
        },
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    )
}