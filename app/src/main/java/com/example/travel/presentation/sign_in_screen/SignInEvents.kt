package com.example.travel.presentation.sign_in_screen

sealed class SignInEvents{

    data class showToast(val message: String) : SignInEvents()
}
