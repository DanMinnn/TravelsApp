package com.example.travel.presentation.sign_in_screen

import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travel.R
import com.example.travel.presentation.NavGraph.Route
import com.example.travel.ui.theme.tripsansFontFamily
import com.example.travel.ui.theme.tripsansRegularFontFamily

@Composable
fun SignUp(
    navController: NavController
) {
    Icon(
        painterResource(id = R.drawable.back_ic),
        contentDescription = null,
        modifier = Modifier.padding(top = 50.dp, start = 20.dp).clickable {
            navController.navigate(Route.SignInEmailScreen.route)
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

        var email by remember {
            mutableStateOf("")
        }
        var isEmailValid by remember { mutableStateOf(true) }
        var isPasswordValid by remember { mutableStateOf(true) }
        var password by remember {
            mutableStateOf("")
        }

        fun validateEmail(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun validatePassword(password: String): Boolean {
            return password.length >= 10 && password.any { it.isDigit() }
                    && password.any({ !it.isLetterOrDigit() })
        }
        Text(
            stringResource(id = R.string.email_address),
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email, onValueChange = { newValue ->
                email = newValue
                isEmailValid = validateEmail(newValue)
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.email_address),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 12.sp)
                )
            },
            isError = !isEmailValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        if (!isEmailValid) {
            Text(
                text = "Please enter a valid email address.",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            stringResource(id = R.string.password),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password, onValueChange = { newValue ->
                password = newValue
                isPasswordValid = validatePassword(newValue)
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.password),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 12.sp)
                )
            },
            isError = !isPasswordValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
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
                    color = if (isPasswordValid) colorResource(id = R.color.condition) else MaterialTheme.colorScheme.error,
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
                    color = if (isPasswordValid) colorResource(id = R.color.condition) else MaterialTheme.colorScheme.error,
                    fontFamily = tripsansRegularFontFamily
                )
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = {
                isEmailValid = validateEmail(email)
                isPasswordValid = validatePassword(password)
                if (isEmailValid && isPasswordValid) {

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            enabled = isEmailValid && isPasswordValid
        ) {
            Text(stringResource(id = R.string.sign_up))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate(Route.SignInEmailScreen.route) },
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

/*
@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp()
}*/
