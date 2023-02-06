package com.cleverlycode.vibes.data.service

interface AccountService {
    fun createAccount(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun signInWithEmailAndPassword(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun isUserAuthenticatedInFirebase(): Boolean
    fun signOut()
    fun sendRecoveryEmail(email: String, onResult: (Throwable?) -> Unit)
}