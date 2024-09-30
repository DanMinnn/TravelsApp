package com.example.travel.presentation.sign_in_screen.forgot_password

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travel.R
import com.example.travel.presentation.nav_graph.Route
import com.example.travel.presentation.sign_in_screen.SignInViewModel
import com.example.travel.ui.theme.tripsansRegularFontFamily

@Composable
fun ForgotPassword(
    openAndPopUp : (String, String) -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
) {

    val email = viewModel.email.collectAsState()
    val errorMessage = viewModel.errorMessage.collectAsState().value

    Icon(
        painterResource(id = R.drawable.back_ic),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 50.dp, start = 20.dp)
            .clickable {
                openAndPopUp(Route.SignInEmailScreen.route, Route.ForgotPassword.route)
            }
    )

    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp)
    ) {
        Text(
            text = "Enter the email address you used to sign up.",
            fontFamily = tripsansRegularFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            stringResource(id = R.string.email_address),
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email.value, onValueChange = {
                viewModel.updateEmail(it)
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.email_address),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 12.sp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {
                viewModel.onSendEmailResetPassword(openAndPopUp)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
        ) {
            Text(text = "Send email")
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "We'll send you a password reset email",
            style = TextStyle(fontFamily = tripsansRegularFontFamily)
        )
    }
}
