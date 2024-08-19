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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

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
                .height(250.dp)
                .padding(start = 5.dp, end = 5.dp)
        ) {
            itemsIndexed(images) { index, item ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp)
                        .height(250.dp)

                ) {
                    Box {
                        Image(
                            painter = painterResource(id = item.image),
                            modifier = Modifier
                                .fillMaxSize()
                                .width(350.dp),
                            contentScale = ContentScale.Crop,
                            contentDescription = "image"
                        )
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(350.dp)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.9f)
                                        )
                                    )
                                )
                                .align(Alignment.BottomCenter)
                        ) {
                            Text(
                                text = item.title,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(start = 25.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.CenterStart)

                            )
                        }
                    }
                }
            }

        }

    }

}