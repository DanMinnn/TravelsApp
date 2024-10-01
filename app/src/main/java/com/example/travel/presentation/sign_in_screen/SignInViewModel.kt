package com.example.travel.presentation.sign_in_screen

import android.util.Log
import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.travel.ERROR_TAG
import com.example.travel.UNEXPECTED_CREDENTIAL
import com.example.travel.data.manager.AuthPreferences
import com.example.travel.data.service.AccountService
import com.example.travel.presentation.TravelsAppViewModel
import com.example.travel.presentation.nav_graph.Route
import com.example.travel.presentation.sign_up.isValidEmail
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val accountService: AccountService,
    private val authPreferences: AuthPreferences
) : TravelsAppViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    private val _errorMessagePassword = MutableStateFlow("")
    val errorMessagePassword = _errorMessagePassword.asStateFlow()

    private val _errorSignIn = MutableLiveData<SignInEvents?>()
    val errorSignIn: LiveData<SignInEvents?> = _errorSignIn

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun resetErrorSignIn(){
        _errorSignIn.value = null
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val email = _email.value.trim()
                val password = _password.value

                when {
                    email.isEmpty() -> {
                        _errorMessage.value = "Please enter a valid email address."
                        return@launch
                    }
                    !email.isValidEmail() -> {
                        _errorMessage.value = "Invalid email format"
                        return@launch
                    }
                    password.isEmpty() -> {
                        _errorMessagePassword.value = "Please enter a valid password."
                        return@launch
                    }
                    else -> {
                        _errorMessage.value = ""
                        _errorMessagePassword.value = ""
                    }
                }

                accountService.signInWithEmail(email, password)

                authPreferences.setUserLoggedIn(true)

                openAndPopUp(Route.HomePage.route, Route.SignInEmailScreen.route)
            } catch (ex: Exception) {
                _errorSignIn.value = SignInEvents.showToast("Please check your email and password and try again")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun onSignInWithGoogle(credential: Credential, openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                accountService.signInWithGoogle(googleIdTokenCredential.idToken)
                authPreferences.setUserLoggedIn(true)
                openAndPopUp(Route.HomePage.route, Route.SignInEmailScreen.route)
            } else {
                Log.e(ERROR_TAG, UNEXPECTED_CREDENTIAL)
            }
        }
    }

    fun onSignInWithEmailClick(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(Route.SignInEmailScreen.route, Route.SignIn.route)
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(Route.SignUp.route, Route.SignIn.route)
    }

    fun onSendEmailResetPassword(openAndPopUp: (String, String) -> Unit) {
        launchCatching {

            if (_email.value.isEmpty()) {
                _errorMessage.value = "Please enter a valid email address."
                return@launchCatching
            } else if (!_email.value.isValidEmail()) {
                _errorMessage.value = "Invalid email format"
                return@launchCatching
            } else {
                _errorMessage.value = ""
            }

            accountService.resetPassword(_email.value)
            openAndPopUp("", "")
        }

    }

    fun signOut() {
        viewModelScope.launch {
            try {
                accountService.signOut()
                authPreferences.setUserLoggedIn(false)
            } catch (ex: Exception) {

            }
        }
    }
}