package com.example.travel.presentation.sign_up

import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travel.R
import com.example.travel.presentation.nav_graph.Route
import com.example.travel.ui.theme.tripsansFontFamily
import com.example.travel.ui.theme.tripsansRegularFontFamily

@Composable
fun SignUp(
    openAndPopUp: (String, String) -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()
    val errorMessage = viewModel.errorMessage.collectAsState().value
    val errorMessagePassword = viewModel.errorMessagePassword.collectAsState().value

    Icon(
        painterResource(id = R.drawable.back_ic),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 50.dp, start = 20.dp)
            .clickable {
                openAndPopUp(Route.SignInEmailScreen.route, Route.SignUp.route)
            }
    )

    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp)
    ) {

        Text(
            text = "Become a Traveler member.",
            style = TextStyle(fontSize = 22.sp, fontFamily = tripsansFontFamily)
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
            fontSize = 12.sp,
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

        Spacer(modifier = Modifier.height(8.dp))

        Row() {
            Icon(
                painterResource(id = R.drawable.x_ic),
                contentDescription = "",
                modifier = Modifier.padding(top = 4.dp),
                tint = Color.Gray
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "At least 10 characters",
                style = TextStyle(
                    color = if (errorMessagePassword.isEmpty()) colorResource(id = R.color.condition) else MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    fontFamily = tripsansRegularFontFamily
                )
            )
        }

        Row() {
            Icon(
                painterResource(id = R.drawable.x_ic),
                contentDescription = "",
                Modifier.padding(top = 4.dp),
                tint = Color.Gray
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "Contains a special character",
                style = TextStyle(
                    color = if (errorMessagePassword.isEmpty()) colorResource(id = R.color.condition) else MaterialTheme.colorScheme.error,
                    fontFamily = tripsansRegularFontFamily
                )
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = {
               viewModel.onSignUpClick(openAndPopUp)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
        ) {
            Text(stringResource(id = R.string.sign_up))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                openAndPopUp(Route.SignInEmailScreen.route, Route.SignUp.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, color = Color.Black),

            ) {
            Text(stringResource(id = R.string.sign_in))
        }
    }
}
