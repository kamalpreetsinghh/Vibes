package com.cleverlycode.vibes.screens.home.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.vibes.data.service.AccountService
import com.cleverlycode.vibes.nav_graphs.AuthRoutes
import com.cleverlycode.vibes.nav_graphs.Graph
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val accountService: AccountService
) : ViewModel() {
    var profileUiState = mutableStateOf(ProfileUiState())
        private set

    fun signOut(navigate: (String) -> Unit) {
        accountService.signOut()
        navigate(Graph.ROOT)
    }
}