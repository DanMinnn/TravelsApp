package com.example.travel.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage(
    openAndPopUp : (String, String) -> Unit
){
    Text(
        text = "This is home page",
        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}