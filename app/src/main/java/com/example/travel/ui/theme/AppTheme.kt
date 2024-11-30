package com.example.travel.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class AppTypography(
    val heading1: TextStyle = TextStyle.Default,
    val titleLarge: TextStyle = TextStyle.Default,
    val subTitleLarge: TextStyle = TextStyle.Default,
    val titleSmall: TextStyle = TextStyle.Default,
    val subTitleSmall: TextStyle = TextStyle.Default,
    val body: TextStyle = TextStyle.Default,
)

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography()
}

@Composable
fun AppTheme(
    content: @Composable () -> Unit
){
    val typography = AppTypography(
        heading1 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black,
            fontFamily = mercenary_medium
        ),
        titleLarge = TextStyle(
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 22.sp,
            fontFamily = mercenary_bold
        ),
        subTitleLarge = TextStyle(
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontSize = 17.sp,
            fontFamily = tt_commons_pro_demi_bold
        ),
        titleSmall = TextStyle(
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = geometric_semibold
        ),
        subTitleSmall = TextStyle(
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            fontSize = 13.sp,
            fontFamily = geometric_medium
        )
    )

    CompositionLocalProvider(LocalAppTypography provides typography) {
        content.invoke()
    }
}

object AppTheme{
    val appTypography: AppTypography
    @Composable
    get() = LocalAppTypography.current
}