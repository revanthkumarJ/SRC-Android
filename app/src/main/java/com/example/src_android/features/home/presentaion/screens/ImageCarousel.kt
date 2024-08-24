package com.example.src_android.features.home.presentaion.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.src_android.R
import com.example.src_android.core.CarouselImage
import com.example.src_android.features.home.presentaion.homeComponents.ImageCarouselItem

@Composable
fun ImageCarousel() {
    val images = listOf(
        CarouselImage(R.drawable.krishna, "this is title"),
        CarouselImage(R.drawable.src_logo, "this is title"),
        CarouselImage(R.drawable.krishna, "this is title"),
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(start = 15.dp, end = 5.dp)
        ) {
            itemsIndexed(images) { index, item ->
                ImageCarouselItem(news = item)
            }
        }
    }
}

