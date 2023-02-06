package com.cleverlycode.vibes.screens.signup

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.vibes.R
import com.cleverlycode.vibes.data.model.Profile
import com.cleverlycode.vibes.data.service.AccountService
import com.cleverlycode.vibes.data.service.ProfileService
import com.cleverlycode.vibes.nav_graphs.Graph
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService,
    private val profileService: ProfileService
) : ViewModel() {
    var signUpUiState = mutableStateOf(SignUpUiState())
        private set

    private val firstName get() = signUpUiState.value.firstName
    private val lastName get() = signUpUiState.value.lastName
    private val email get() = signUpUiState.value.email
    private val password get() = signUpUiState.value.password
    private val confirmPassword get() = signUpUiState.value.confirmPassword

    fun onFirstNameChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(firstName = newValue)
        enableOrDisableButton()
    }

    fun onLastNameChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(lastName = newValue)
        enableOrDisableButton()
    }

    fun onEmailChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(email = newValue)
        signUpUiState.value = signUpUiState.value.copy(
            isEmailError = false,
            emailErrorMsgResId = null
        )
        enableOrDisableButton()
    }

    fun onPasswordChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(password = newValue)
        signUpUiState.value = signUpUiState.value.copy(
            isPasswordError = false,
            passwordErrorMsgResId = null
        )
        enableOrDisableButton()
    }

    fun onConfirmPasswordChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(confirmPassword = newValue)
        signUpUiState.value = signUpUiState.value.copy(
            isConfirmPasswordError = false,
            confirmPasswordErrorMsgResId = null
        )
        enableOrDisableButton()
    }

    fun onSignUpClick(navigate: (String) -> Unit) {
        if (isValidSignUpDetails()) {
            viewModelScope.launch {
                accountService.createAccount(email, password) { error ->
                    if (error == null) {
                        val profile = Profile(
                            firstName = firstName,
                            lastName = lastName,
                            email = email
                        )
                        profileService.createProfile(profile)
                        navigate(Graph.HOME)
                    } else {
                        if (error is FirebaseAuthUserCollisionException) {
                            emailAlreadyExists()
                        } else if (error is FirebaseAuthWeakPasswordException) {
                            weakPassword()
                        }
                    }
                }
            }
        }
    }

    private fun enableOrDisableButton() {
        signUpUiState.value =
            signUpUiState.value.copy(isButtonEnabled = isButtonEnabled())
    }

    private fun isButtonEnabled() = firstName.isNotEmpty() && lastName.isNotEmpty()
            && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()

    fun togglePasswordIcon() {
        signUpUiState.value =
            signUpUiState.value.copy(isPasswordVisible = !signUpUiState.value.isPasswordVisible)
    }

    fun toggleConfirmPasswordIcon() {
        signUpUiState.value =
            signUpUiState.value.copy(isConfirmPasswordVisible = !signUpUiState.value.isConfirmPasswordVisible)
    }

    private fun isValidSignUpDetails(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpUiState.value = signUpUiState.value.copy(
                isEmailError = true,
                emailErrorMsgResId = R.string.error_invalid_email
            )
            return false
        }

        if (!doPasswordsMatch()) {
            signUpUiState.value = signUpUiState.value.copy(
                isConfirmPasswordError = true,
                confirmPasswordErrorMsgResId = R.string.error_confirm_password
            )
            return false
        }

        return true
    }

    private fun doPasswordsMatch() = password == confirmPassword

    private fun emailAlreadyExists() {
        signUpUiState.value = signUpUiState.value.copy(
            isEmailError = true,
            emailErrorMsgResId = R.string.error_email_already_exists
        )
    }

    private fun weakPassword() {
        signUpUiState.value = signUpUiState.value.copy(
            isPasswordError = true,
            isConfirmPasswordError = true,
            confirmPasswordErrorMsgResId = R.string.error_weak_password
        )
    }
}