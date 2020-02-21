package jp.gree.techcon.wrapper

import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object Auth {
    private val auth by lazy { FirebaseAuth.getInstance() }

    fun isLoggedIn() = auth.currentUser != null

    suspend fun signIn(): Boolean = suspendCoroutine { continuation ->
        FirebaseAuth.getInstance().signInAnonymously().addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(true)
            } else {
                continuation.resume(false)
            }
        }
    }

    suspend fun token(): String? = suspendCoroutine { continuation ->
        val user = auth.currentUser
        if (user == null) {
            continuation.resume(null)
            return@suspendCoroutine
        }

        user.getIdToken(true).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(it.result!!.token)
            } else {
                continuation.resume(null)
            }
        }
    }
}
