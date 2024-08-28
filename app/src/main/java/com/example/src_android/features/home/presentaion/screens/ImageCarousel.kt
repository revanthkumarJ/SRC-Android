package com.example.src_android.features.home.presentaion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.src_android.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.src_android.core.CarouselImage
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.src_android.features.home.presentaion.HomeViewModel
import com.example.src_android.features.home.presentaion.homeComponents.ImageCarouselItem

@Composable
fun ImageCarousel(homeViewModel: HomeViewModel) {
    val carousels by homeViewModel.carouselData.observeAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyRow(
            modifier = Modifier
                .height(250.dp)
                .padding(start = 15.dp, end = 5.dp)
        ) {
            carousels?.let {
                it.map {
                    item {
                        ImageCarouselItem(it)
                    }
                }
            }
        }

    }

}

