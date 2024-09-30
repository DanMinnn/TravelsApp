package com.example.travel.presentation.sign_up

import com.example.travel.data.service.AccountService
import com.example.travel.presentation.TravelsAppViewModel
import com.example.travel.presentation.nav_graph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
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

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit){
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

            if(!_password.value.isValidPassword()){
                _errorMessagePassword.value = "Invalid"
                return@launchCatching
            }else{
                _errorMessagePassword.value = ""
            }

            accountService.signUpWithEmail(_email.value, _password.value)
            openAndPopUp(Route.SignInEmailScreen.route, Route.SignUp.route)
        }
    }
}