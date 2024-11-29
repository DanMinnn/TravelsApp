package com.example.travel.presentation.main_screen.account_screen


import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.ui.theme.tripsansFontFamily
import com.example.travel.ui.theme.tripsansRegularFontFamily

@Composable
fun CommonListItem(
    @DrawableRes icon: Int,
    text: String,
    //@DrawableRes arrowIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconTint: Color = Color.Black,
    textStyle: TextStyle = TextStyle(fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Medium),
) {

    Row(
        modifier = modifier.fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = text,
                style = textStyle
            )
        }

        Icon(
            painter = painterResource(R.drawable.arrow,),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}