package com.example.travel.presentation.sign_in_screen

import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import com.example.travel.ERROR_TAG
import com.example.travel.R
import com.example.travel.UNEXPECTED_CREDENTIAL
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
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val accountService: AccountService
) : TravelsAppViewModel(){

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    private val _errorMessagePassword = MutableStateFlow("")
    val errorMessagePassword = _errorMessagePassword.asStateFlow()

    fun updateEmail(newEmail: String){
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String){
        _password.value = newPassword
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit){
        launchCatching {

            if (_email.value.isEmpty()){
                _errorMessage.value = "Please enter a valid email address."
                return@launchCatching
            }
            else if (!_email.value.isValidEmail()){
                _errorMessage.value = "Invalid email format"
                return@launchCatching
            }else {
                _errorMessage.value = ""
            }

            if(_password.value.isEmpty()){
                _errorMessagePassword.value = "Please enter a valid password."
                return@launchCatching
            }else {
                _errorMessagePassword.value = ""
            }

            accountService.signInWithEmail(_email.value, _password.value)
            openAndPopUp(Route.HomePage.route, Route.SignInEmailScreen.route)
        }
    }

    fun onSignInWithGoogle(credential: Credential, openAndPopUp: (String, String) -> Unit){
        launchCatching {
            if(credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL){
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                accountService.signInWithGoogle(googleIdTokenCredential.idToken)
                openAndPopUp(Route.HomePage.route, Route.SignInEmailScreen.route)
            }else{
                Log.e(ERROR_TAG, UNEXPECTED_CREDENTIAL)
            }
        }
    }

    fun onSignInWithEmailClick(openAndPopUp: (String, String) -> Unit){
        openAndPopUp(Route.SignInEmailScreen.route, Route.SignIn.route)
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(Route.SignUp.route, Route.SignIn.route)
    }

    fun onSendEmailResetPassword(openAndPopUp: (String, String) -> Unit){
        launchCatching {

            if (_email.value.isEmpty()){
                _errorMessage.value = "Please enter a valid email address."
                return@launchCatching
            }
            else if (!_email.value.isValidEmail()){
                _errorMessage.value = "Invalid email format"
                return@launchCatching
            }else {
                _errorMessage.value = ""
            }

            accountService.resetPassword(_email.value)
            openAndPopUp("", "")
        }

    }
}