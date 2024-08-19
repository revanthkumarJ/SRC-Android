package com.example.src_android.core

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavModel(
    val filledImage : Painter,
    val outlinedImage : Painter,
    val route : String
)

data class CarouselImage(
    val image : Int,
    val title : String,
)

data class News(
    val image : Int,
    val title : String,
    val description : String,
)