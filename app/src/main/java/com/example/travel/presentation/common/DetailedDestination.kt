package com.example.travel.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel.R
import com.example.travel.presentation.main_screen.search_screen.SearchScreen
import com.example.travel.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmsterdamScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        // Header Section
        TopAppBar(
            title = { Text(text = "Amsterdam", style = AppTheme.appTypography.titleLarge.copy(color = Color.Black)) },
            navigationIcon = {
                IconButton(onClick = { /* Handle back */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(

            )
        )

        // Tab Row
        val tabs = listOf("Overview", "Hotels", "Things to do", "Restaurants")
        var selectedTabIndex by remember { mutableStateOf(0) }

        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = Color.Black
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = title, style = AppTheme.appTypography.titleSmall) }
                )
            }
        }

        // Image Section
        Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
            Image(
                painter = painterResource(id = R.drawable.background_default), // Replace with your image
                contentDescription = "Amsterdam Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "4/999+",
                style = AppTheme.appTypography.titleSmall.copy(color = Color.White),
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        color = Color.Black.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }

        // Content Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Amsterdam",
                style = AppTheme.appTypography.heading1,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "About Amsterdam",
                style = AppTheme.appTypography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "From its picturesque canals and bridges to its historic homes, Amsterdam could be considered straight out of a fairytale (and the brightly-colored bicycles and tulip scenes only add to the storybook setting).",
                style = AppTheme.appTypography.subTitleLarge.copy(Color.Black),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = { /* Expand Text */ }) {
                Text(text = "Read more", color = Color.Blue)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* View Map */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
            ) {
                Icon(Icons.Default.LocationOn, contentDescription = "View Map", modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "View map")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // "Do" Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Do",
                    style = AppTheme.appTypography.heading1
                )
                TextButton(onClick = { /* See All */ }) {
                    Text(text = "See all", color = Color.Blue)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            /*LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(5) { index ->
                    DoCard()
                }
            }*/
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AmsterdamScreenPreview(){
    AppTheme {
        AmsterdamScreen()
    }
}


