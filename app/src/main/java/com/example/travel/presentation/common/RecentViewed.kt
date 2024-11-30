package com.example.travel.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.travel.R
import com.example.travel.ui.theme.AppTheme

@Composable
fun RecentViewed(
    modifier: Modifier = Modifier,
    destination: String,
    location: String?,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = modifier.wrapContentSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        border = BorderStroke(1.dp, color = colorResource(R.color.light_gray)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = destination,
                style = AppTheme.appTypography.titleSmall,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = location!!,
                style = AppTheme.appTypography.subTitleSmall
            )
        }
    }

    Spacer(modifier = Modifier.width(8.dp))
}