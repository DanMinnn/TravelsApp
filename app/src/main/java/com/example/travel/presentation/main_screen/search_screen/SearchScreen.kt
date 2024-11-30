package com.example.travel.presentation.main_screen.search_screen

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.data.model.Adventure
import com.example.travel.data.model.sampleTrendingList
import com.example.travel.presentation.common.ImageCard
import com.example.travel.presentation.common.RecentViewed
import com.example.travel.presentation.common.SearchBar
import com.example.travel.presentation.main_screen.hom_screen.NearbySection
import com.example.travel.presentation.main_screen.hom_screen.TrendingCard
import com.example.travel.ui.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(

) {
    LazyColumn(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
    ) {
        item {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Search",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(horizontal = 50.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(vertical = 8.dp)
            ) {
                SearchBar(
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 40.dp)
            ) {
                items(sampleTrendingList) { trending ->
                    RecentViewed(
                        destination = trending.title,
                        location = trending.location,
                        onClick = {}
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Top experiences on OwlAdvisor",
                style = AppTheme.appTypography.heading1,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))

            LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
                items(sampleTrendingList) { trending ->
                    TopExperiences(trending)
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Weekend getaways",
                style = AppTheme.appTypography.heading1,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        items(sampleTrendingList) { trending ->
            WeekendGetaways(trending)
            Spacer(modifier = Modifier.height(12.dp))
        }

    }
}

@Composable
fun TopExperiences(
    adventure: Adventure
){
    Spacer(modifier = Modifier.height(8.dp))

    Column() {
        ImageCard(
            imageRes = adventure.imageRes,
            isOverlayEnabled = false,
            onClick = {},
            modifier = Modifier
                .width(240.dp)
                .height(240.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = adventure.title,
            style = AppTheme.appTypography.titleSmall.copy(fontSize = 18.sp),
            modifier = Modifier.padding(start = 5.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = adventure.location,
            style = AppTheme.appTypography.subTitleSmall.copy(fontSize = 14.sp),
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
fun WeekendGetaways(
    adventure: Adventure
){

    Spacer(modifier = Modifier.height(14.dp))

    Row(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        ImageCard(
            imageRes = adventure.imageRes,
            isOverlayEnabled = false,
            onClick = {},
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(6.dp))

        Column {
            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = adventure.title,
                style = AppTheme.appTypography.titleSmall.copy(fontSize = 18.sp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = adventure.location,
                style = AppTheme.appTypography.subTitleSmall.copy(fontSize = 14.sp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SearchScreenPreview() {
    SearchScreen()
}