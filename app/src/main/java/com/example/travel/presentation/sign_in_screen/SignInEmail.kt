package com.example.travel.presentation.sign_in_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.ui.theme.TravelTheme

@Composable
fun SignInEmail(

) {

    Icon(
        painterResource(id = R.drawable.back_ic),
        contentDescription = null,
        modifier = Modifier.padding(20.dp)
    )

    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        var email by remember {
            mutableStateOf("")
        }

        var password by remember {
            mutableStateOf("")
        }

        Text(
            stringResource(id = R.string.email_address),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email, onValueChange = { newValue ->
                email = newValue
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.email_address),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 12.sp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            stringResource(id = R.string.password),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password, onValueChange = { newValue ->
                password = newValue
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.password),
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 12.sp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            stringResource(id = R.string.forgot_password),
            color = colorResource(id = R.color.purple),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth().height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(stringResource(id = R.string.sign_in))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth().height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Text(stringResource(id = R.string.sign_up))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInEmailPreview() {
    SignInEmail()
}