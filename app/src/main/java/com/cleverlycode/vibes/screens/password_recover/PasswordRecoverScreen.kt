package com.cleverlycode.vibes.screens.password_recover

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cleverlycode.vibes.rememberAppState
import com.cleverlycode.vibes.theme.VibesTheme

@Composable
fun PasswordRecoverScreen(
    navigate: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PasswordRecoverViewModel = hiltViewModel()
) {
    val loginUiState by viewModel.passwordRecoverUiState

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = loginUiState.email,
            onValueChange = { viewModel.onPasswordRecoverEmailChange(newValue = it) },
            label = { Text(stringResource(com.cleverlycode.vibes.R.string.label_email)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            )
        )

        Spacer(Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(12.dp),
            onClick = {
                viewModel.onRecoverPasswordClick(navigate)
            }
        ) {
            Text("Recover Password")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VibesTheme(darkTheme = false) {
        val appState = rememberAppState()
        PasswordRecoverScreen(
            navigate = { route -> appState.navigate(route) }
        )
    }
}