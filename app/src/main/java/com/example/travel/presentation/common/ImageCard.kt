package com.example.travel.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.travel.R
import com.example.travel.ui.theme.AppTheme

@Composable
fun ImageCard(
    imageRes: Int,
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
    isOverlayEnabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(305.dp)
            .height(305.dp)
            .padding(end = 8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box {
            // Background image
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            if (isOverlayEnabled) {
                // Overlay gradient
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(305.dp)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ), startY = 250f
                            )
                        )
                )
                // Overlay text
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black,
                                    Color.Transparent
                                ), startY = 300f
                            )
                        )
                        .padding(8.dp),
                    contentAlignment = Alignment.BottomStart
                )  {
                    Column(modifier = Modifier.padding(16.dp)) {
                        title?.let {
                            Text(
                                text = it,
                                style = AppTheme.appTypography.titleLarge,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        subtitle?.let {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = it,
                                style = AppTheme.appTypography.subTitleLarge,
                                color = Color.White,
                                maxLines = 1
                            )
                        }
                    }
                }
            }

            // Favorite icon
            Icon(
                painter = painterResource(R.drawable.heart_outline_ic_bottom),
                contentDescription = "Favorite",
                tint = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
                    .clickable { /* Handle click */ }
            )
        }
    }
}
