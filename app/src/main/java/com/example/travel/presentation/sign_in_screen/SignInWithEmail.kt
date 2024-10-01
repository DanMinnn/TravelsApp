package com.example.travel.presentation.sign_in_screen

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travel.R
import com.example.travel.presentation.nav_graph.Route

@Composable
fun SignInEmail(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()

    val errorSignIn by viewModel.errorSignIn.observeAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val context = LocalContext.current

    Icon(
        painterResource(id = R.drawable.back_ic),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 50.dp, start = 20.dp)
            .clickable {
                openAndPopUp(Route.SignIn.route, Route.SignInEmailScreen.route)
            }
    )

    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp),
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            stringResource(id = R.string.email_address),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email.value, onValueChange = {
                viewModel.updateEmail(it)
                //isValidEmail = validateEmail(it)
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.email_address),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 12.sp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        val errorMessage = viewModel.errorMessage.collectAsState().value

        if (errorMessage.isNotEmpty()){
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            stringResource(id = R.string.password),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password.value, onValueChange = {
                viewModel.updatePassword(it)
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.password),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 12.sp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        val errorMessagePassword = viewModel.errorMessagePassword.collectAsState().value

        if (errorMessagePassword.isNotEmpty()){
            Text(
                text = errorMessagePassword,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            stringResource(id = R.string.forgot_password),
            color = colorResource(id = R.color.purple),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    openAndPopUp(Route.ForgotPassword.route, Route.SignInEmailScreen.route)
                },
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = {
                viewModel.onSignInClick(openAndPopUp)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            if (isLoading){
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }else{
                Text(stringResource(id = R.string.sign_in))
            }

        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { viewModel.onSignUpClick(openAndPopUp) },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Text(stringResource(id = R.string.sign_up))
        }
    }

    LaunchedEffect(key1 = errorSignIn) {
        errorSignIn?.let {
            when(it){
                is SignInEvents.showToast -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.resetErrorSignIn()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInEmailPreview() {
    //SignInEmail()
}
