package com.example.travel.presentation.sign_in_screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.ui.theme.tripsansFontFamily
import com.example.travel.ui.theme.tripsansRegularFontFamily

@Composable
fun SignIn(

) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(200.dp))

        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            stringResource(id = R.string.sign_in_title),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily = tripsansFontFamily
        )

        Spacer(modifier = Modifier.height(12.dp))

        var isPress by remember {
            mutableStateOf(false)
        }
        Button(
            onClick = { isPress = !isPress},
            modifier = Modifier.size(width = 300.dp, height = 48.dp).clickable {  },
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isPress) Color.DarkGray else Color.White,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(24.dp),

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),

                ) {
                Image(
                    painterResource(id = R.drawable.google_ic),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(45.dp))

                Text(
                    stringResource(id = R.string.sign_in_gg),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        var isPressed by remember {
            mutableStateOf(false)
        }

        Button(
            onClick = { isPressed = !isPressed },
            modifier = Modifier.size(width = 300.dp, height = 48.dp).clickable {  },
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isPressed) Color.DarkGray else Color.White,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(24.dp),

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),

                ) {
                Image(
                    painterResource(id = R.drawable.email_ic),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(45.dp))

                Text(
                    stringResource(id = R.string.sign_in_email),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignIn()
}