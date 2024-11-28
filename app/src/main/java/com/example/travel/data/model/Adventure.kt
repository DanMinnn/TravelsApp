package com.example.travel.data.model

import com.example.travel.R

data class Adventure(val title: String, val location: String, val imageRes: Int)

val sampleAdventureList = listOf(
    Adventure("Crete", "Greece", R.drawable.crete),
    Adventure("Playa del Carmen", "Mexico", R.drawable.playa),
    Adventure("Bali", "Indonesia", R.drawable.bali)
)

val sampleTrendingList = listOf(
    Adventure("Waterfalls", "Costa Rica", R.drawable.waterfall),
    Adventure("Petronas Towers", "Malaysia", R.drawable.petronas),
    Adventure("City Lights", "Japan", R.drawable.city_lights)
)
