package com.cleverlycode.vibes.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cleverlycode.vibes.R
import com.cleverlycode.vibes.composables.AnnotatedClickableText
import com.cleverlycode.vibes.composables.AppLogo
import com.cleverlycode.vibes.composables.CustomButton
import com.cleverlycode.vibes.composables.TextFieldWithError
import com.cleverlycode.vibes.nav_graphs.AuthRoutes
import com.cleverlycode.vibes.rememberAppState
import com.cleverlycode.vibes.theme.*

@Composable
fun LoginScreen(
    navigate: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val loginUiState by viewModel.loginUiState

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
                .padding(24.dp)
                .background(color = Color(0xdfe4e7)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AppLogo()

            Spacer(modifier = Modifier.height(36.dp))

            TextFieldWithError(
                value = loginUiState.email,
                onValueChange = { viewModel.onEmailChange(newValue = it) },
                label = stringResource(R.string.label_username),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                isError = loginUiState.isEmailError,
                errorMsgResId = loginUiState.emailErrorMsgResId,
                keyboardType = KeyboardType.Email
            )

            Spacer(Modifier.height(16.dp))

            TextFieldWithError(
                value = loginUiState.password,
                onValueChange = { viewModel.onPasswordChange(newValue = it) },
                label = stringResource(R.string.label_password),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                isError = loginUiState.isPasswordError,
                errorMsgResId = loginUiState.passwordErrorMsgResId,
                keyboardType = KeyboardType.Password,
                visualTransformation = if (loginUiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { viewModel.togglePasswordIcon() }) {
                        Icon(
                            imageVector = if (loginUiState.isPasswordVisible) Icons.Filled.Check else Icons.Filled.CheckCircle,
                            contentDescription = "Password Icon"
                        )
                    }
                }
            )

            Spacer(Modifier.height(16.dp))

            ClickableText(
                text = AnnotatedString(stringResource(R.string.label_forgot_password)),
                onClick = {
                    viewModel.onForgotPasswordClick(navigate)
                },
                modifier = Modifier.align(Alignment.End),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Blue
                )
            )

            Spacer(Modifier.height(16.dp))

            CustomButton(
                label = stringResource(R.string.label_sign_in),
                onClick = { viewModel.onSignInClick(navigate) },
                enabled = loginUiState.isButtonEnabled,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextBetweenLines()

            Spacer(modifier = Modifier.height(24.dp))

            CustomButton(
                label = "Continue with Google",
                onClick = { /*TODO*/ },
                color = Color.White,
                textColor = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomButton(
                label = "Continue with Facebook",
                onClick = { /*TODO*/ },
                color = Blue,
                textColor = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            AnnotatedClickableText(
                text = stringResource(R.string.label_sign_up_text),
                clickableText = stringResource(R.string.label_sign_up),
                route = AuthRoutes.SignUp.route,
                navigate = navigate
            )
        }
    }
}

@Composable
private fun TextBetweenLines(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DividerLine(color = Color.White)

        Text(
            text = "OR",
            color = Color.White
        )

        DividerLine(color = Color.White)
    }
}

@Composable
private fun DividerLine(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Divider(
        thickness = 0.5.dp,
        color = color,
        modifier = modifier
            .width(160.dp)
            .padding(horizontal = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VibesTheme(darkTheme = false) {
        val appState = rememberAppState()
        LoginScreen(
            navigate = { route -> appState.navigate(route) }
        )
    }
}


