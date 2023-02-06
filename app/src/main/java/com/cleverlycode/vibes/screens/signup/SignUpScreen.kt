package com.cleverlycode.vibes.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import com.cleverlycode.vibes.theme.EndGradient
import com.cleverlycode.vibes.theme.StartGradient
import com.cleverlycode.vibes.theme.VibesTheme


@Composable
fun SignUpScreen(
    navigateAndPopBackStack: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val signUpUiState by viewModel.signUpUiState

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
            AppLogo()

            Spacer(modifier = Modifier.height(36.dp))

            TextFieldWithError(
                value = signUpUiState.firstName,
                onValueChange = { viewModel.onFirstNameChange(newValue = it) },
                label = stringResource(R.string.label_first_name),
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(12.dp))

            TextFieldWithError(
                value = signUpUiState.lastName,
                onValueChange = { viewModel.onLastNameChange(newValue = it) },
                label = stringResource(R.string.label_last_name),
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(12.dp))

            TextFieldWithError(
                value = signUpUiState.email,
                onValueChange = { viewModel.onEmailChange(newValue = it) },
                label = stringResource(R.string.label_email),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                isError = signUpUiState.isEmailError,
                errorMsgResId = signUpUiState.emailErrorMsgResId,
                keyboardType = KeyboardType.Email
            )

            Spacer(Modifier.height(12.dp))

            TextFieldWithError(
                value = signUpUiState.password,
                onValueChange = { viewModel.onPasswordChange(newValue = it) },
                label = stringResource(R.string.label_password),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                isError = signUpUiState.isPasswordError,
                errorMsgResId = signUpUiState.passwordErrorMsgResId,
                keyboardType = KeyboardType.Password,
                visualTransformation = if (signUpUiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { viewModel.togglePasswordIcon() }) {
                        Icon(
                            imageVector = if (signUpUiState.isPasswordVisible) Icons.Filled.Check else Icons.Filled.CheckCircle,
                            contentDescription = "Password Icon"
                        )
                    }
                }
            )

            Spacer(Modifier.height(12.dp))

            TextFieldWithError(
                value = signUpUiState.confirmPassword,
                onValueChange = { viewModel.onConfirmPasswordChange(newValue = it) },
                label = stringResource(R.string.label_confirm_password),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                isError = signUpUiState.isConfirmPasswordError,
                errorMsgResId = signUpUiState.confirmPasswordErrorMsgResId,
                keyboardType = KeyboardType.Password,
                visualTransformation = if (signUpUiState.isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { viewModel.toggleConfirmPasswordIcon() }) {
                        Icon(
                            imageVector = if (signUpUiState.isConfirmPasswordVisible) Icons.Filled.Check else Icons.Filled.CheckCircle,
                            contentDescription = "Password Icon"
                        )
                    }
                }
            )

            Spacer(Modifier.height(16.dp))

            CustomButton(
                label = stringResource(R.string.label_create_account),
                onClick = { viewModel.onSignUpClick(navigateAndPopBackStack) },
                enabled = signUpUiState.isButtonEnabled,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            AnnotatedClickableText(
                text = stringResource(R.string.label_sign_in_text),
                clickableText = stringResource(R.string.label_sign_in),
                route = AuthRoutes.Login.route,
                navigate = navigateAndPopBackStack
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VibesTheme(darkTheme = false) {
        SignUpScreen(navigateAndPopBackStack = { })
    }
}
