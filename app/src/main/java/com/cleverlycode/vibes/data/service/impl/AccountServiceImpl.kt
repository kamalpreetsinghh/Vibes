package com.cleverlycode.vibes.data.service.impl

import com.cleverlycode.vibes.data.service.AccountService
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class AccountServiceImpl @Inject constructor() : AccountService {
    override fun createAccount(email: String, password: String, onResult: (Throwable?) -> Unit) {
        Firebase.auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            onResult(it.exception)
        }
    }

    override fun signInWithEmailAndPassword(
        email: String, password: String, onResult: (Throwable?) -> Unit
    ) {
        Firebase.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            onResult(it.exception)
        }
    }

    override fun isUserAuthenticatedInFirebase() = Firebase.auth.currentUser != null

    override fun signOut() {
        Firebase.auth.signOut()
    }

    override fun sendRecoveryEmail(email: String, onResult: (Throwable?) -> Unit) {
        Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { onResult(it.exception) }
    }
}