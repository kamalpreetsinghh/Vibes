package com.cleverlycode.vibes.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cleverlycode.vibes.theme.VibesTheme

@Composable
fun CustomButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    color: Color? = null,
    textColor: Color? = null
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(12.dp),
        onClick = onClick,
        enabled = enabled,
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color ?: MaterialTheme.colors.primary
        )
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
        }
        Text(
            text = label,
            color = textColor ?: MaterialTheme.colors.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VibesTheme(darkTheme = false) {
        CustomButton("Kamal is the best", {})
    }
}
