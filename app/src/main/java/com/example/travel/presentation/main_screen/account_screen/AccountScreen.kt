package com.example.travel.presentation.main_screen.account_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.travel.presentation.common.CommonButton

@Composable
fun AccountScreen(
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(40.dp)
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Account",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.width(170.dp))

            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "avt",
                modifier = Modifier.clip(shape = CircleShape)
                    .clickable {

                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        CommonListItem(
            icon = R.drawable.account,
            text = "Profile",
            onClick = {}
        )
        HorizontalDivider(thickness = 1.dp, color = colorResource(R.color.color_divider))

        CommonListItem(
            icon = R.drawable.bookings,
            text = "Bookings",
            onClick = {}
        )
        HorizontalDivider(thickness = 1.dp, color = colorResource(R.color.color_divider))

        CommonListItem(
            icon = R.drawable.notifications,
            text = "Notifications",
            onClick = {}
        )
        HorizontalDivider(thickness = 1.dp, color = colorResource(R.color.color_divider))

        CommonListItem(
            icon = R.drawable.preferences,
            text = "Preferences",
            onClick = {}
        )
        HorizontalDivider(thickness = 1.dp, color = colorResource(R.color.color_divider))

        CommonListItem(
            icon = R.drawable.support,
            text = "Support",
            onClick = {}
        )
        HorizontalDivider(thickness = 1.dp, color = colorResource(R.color.color_divider))

        Spacer(modifier = Modifier.height(20.dp))
        
        CommonButton(
            onClick = { },
            text = stringResource(R.string.sign_out),
        )
    }
}

@Composable
@Preview
fun AccountPreview(){
    AccountScreen()
}