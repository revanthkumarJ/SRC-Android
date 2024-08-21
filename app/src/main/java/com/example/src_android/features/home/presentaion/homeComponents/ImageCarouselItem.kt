package com.example.src_android.features.home.presentaion.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.src_android.core.CarouselImage

@Composable
fun ImageCarouselItem(news: CarouselImage) {
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
                painter = painterResource(id = news.image),
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
                    text = news.title,
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