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
import com.example.travel.presentation.common.ImageCard
import com.example.travel.presentation.common.SearchBar
import com.example.travel.ui.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    //openAndPopUp: (String, String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),

    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(R.drawable.logo), contentDescription = null)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "OwlAdvisor",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(vertical = 8.dp)
            ) {
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
                text = "Looking for something nearby?",
                style = AppTheme.appTypography.titleSmall.copy(fontSize = 15.sp),
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
    Column() {
        Text(
            "Plan your next adventure",
            style = AppTheme.appTypography.heading1,
            modifier = Modifier.padding(start = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 40.dp)
        ) {
            items(sampleAdventureList) { adventure ->
                AdventureCard(adventure)
            }
        }
    }
}

@Composable
fun AdventureCard(adventure: Adventure) {

    ImageCard(
        imageRes = adventure.imageRes,
        title = adventure.title,
        subtitle = adventure.location,
        isOverlayEnabled = true,
        onClick = {}
    )

}

@Composable
fun TrendingCard(adventure: Adventure) {

    Column(modifier = Modifier.padding(end = 8.dp)) {

        ImageCard(
            imageRes = adventure.imageRes,
            title = adventure.title,
            subtitle = adventure.location,
            isOverlayEnabled = false,
            onClick = {},
            modifier = Modifier
                .width(180.dp)
                .height(240.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(12.dp))
        )


        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = adventure.title,
            style = AppTheme.appTypography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 5.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = adventure.location,
            style = AppTheme.appTypography.subTitleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
fun TrendingSection() {
    Column() {
        Text(
            "Trending with travelers",
            style = AppTheme.appTypography.heading1,
            modifier = Modifier.padding(start = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 40.dp)) {
            items(sampleTrendingList) { trending ->
                TrendingCard(trending)
            }
        }
    }
}

@Composable
fun BestOfBest() {
    Column() {
        Text(
            "Trending with travelers",
            style = AppTheme.appTypography.heading1,
            modifier = Modifier.padding(start = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 40.dp)) {
            items(sampleTrendingList) { trending ->
                TrendingCard(trending)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview() {
    //HomeScreen (openAndPopUp = { route, popUp -> })
}