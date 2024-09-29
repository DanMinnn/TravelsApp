package com.example.travel.presentation.sign_in_screen

import android.util.Patterns

class ValidateEmail {
    fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}