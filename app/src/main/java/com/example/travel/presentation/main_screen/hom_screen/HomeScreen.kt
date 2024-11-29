package com.example.travel.presentation.main_screen.hom_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.data.model.Adventure
import com.example.travel.data.model.sampleAdventureList
import com.example.travel.data.model.sampleTrendingList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    //openAndPopUp: (String, String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        stickyHeader {
           Box(
               modifier = Modifier
                   .fillMaxWidth()
                   .background(color = Color.White)
                   .padding(vertical = 8.dp)
           ){
               SearchBar()
           }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            NearbySection()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            AdventureSection()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            TrendingSection()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            BestOfBest()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(
                stringResource(R.string.search),
                style = TextStyle(fontSize = 12.sp, textAlign = TextAlign.Center)
            )
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp)
            )
        },
        shape = RoundedCornerShape(30.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(horizontal = 12.dp)
            .border(
                width = 1.dp,
                color = colorResource(R.color.light_gray),
                shape = RoundedCornerShape(30.dp)
            )

    )
}

@Composable
fun NearbySection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp)
            .clickable {

            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(R.drawable.location),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .background(
                    colorResource(R.color.color_theme), shape = CircleShape
                )
                .size(32.dp)
                .padding(8.dp)
        )

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Looking for something nearby?", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Allow location access", style = TextStyle(
                    fontSize = 12.sp
                )
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Icon(
                Icons.Default.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun AdventureSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            "Plan your next adventure", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ), modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            items(sampleAdventureList) { adventure ->
                AdventureCard(adventure)
            }
        }
    }
}

@Composable
fun AdventureCard(adventure: Adventure) {
    Card(
        modifier = Modifier
            .width(250.dp)
            .padding(end = 8.dp)
            .clickable { /* Navigate to details */ },
        shape = RoundedCornerShape(12.dp)
    ) {
        Box {
            // Background image
            Image(
                painter = painterResource(id = adventure.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), startY = 250f
                        )
                    )
            )

            // Overlay for text and icon
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
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = adventure.title,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = adventure.location,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 12.sp
                        ),
                        maxLines = 1
                    )
                }
            }

            // Favorite icon
            Icon(
                painterResource(R.drawable.heart_outline_ic_bottom),
                contentDescription = "Favorite",
                tint = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
                    .background(
                        color = Color.White, shape = CircleShape
                    )
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
                    .clickable {

                    }
            )
        }

    }
}

@Composable
fun TrendingCard(adventure: Adventure) {

    Column(modifier = Modifier.padding(end = 8.dp)) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(12.dp))
        ) {

            Image(
                painter = painterResource(id = adventure.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Icon(
                painterResource(R.drawable.heart_outline_ic_bottom),
                contentDescription = "Favorite",
                tint = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
                    .background(
                        color = Color.White, shape = CircleShape
                    )
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
                    .clickable {

                    }
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = adventure.title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 12.sp
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = adventure.location,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray,
                fontSize = 10.sp
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun TrendingSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            "Trending with travelers", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ), modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 12.dp)) {
            items(sampleTrendingList) { trending ->
                TrendingCard(trending)
            }
        }
    }
}

@Composable
fun BestOfBest() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            "Trending with travelers", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ), modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 12.dp)) {
            items(sampleTrendingList) { trending ->
                TrendingCard(trending)
            }
        }
    }
}

/*@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { *//* Navigate to Home *//* },
            icon = { Icon(painterResource(R.drawable.home), contentDescription = null) },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { *//* Navigate to Search *//* },
            icon = { Icon(Icons.Default.Search, contentDescription = null) },
            label = { Text("Search") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { *//* Navigate to Trips *//* },
            icon = { Icon(painterResource(R.drawable.trip), contentDescription = null) },
            label = { Text("Trips") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { *//* Navigate to Trips *//* },
            icon = { Icon(painterResource(R.drawable.review), contentDescription = null) },
            label = { Text("Review") }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
            },
            icon = { Icon(painterResource(R.drawable.account), contentDescription = null) },
            label = { Text("Account") }
        )
    }
}*/

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview() {
    //HomeScreen (openAndPopUp = { route, popUp -> })
}