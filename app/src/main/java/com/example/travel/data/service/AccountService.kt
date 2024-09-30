package com.example.travel.data.service

import com.example.travel.data.model.User
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser: Flow<User?>
    val currentUserId: String
    fun hasUser(): Boolean
    fun getUserProfile(): User
    suspend fun updateDisplayName(newDisplayName: String)
    suspend fun signInWithGoogle(idToken: String)
    suspend fun signInWithEmail(email: String, password: String)
    suspend fun signUpWithEmail(email: String, password: String)
    suspend fun resetPassword(email: String)
    suspend fun signOut()
    suspend fun deleteAccount()
}