package com.example.src_android.core

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavModel(
    val filledImage : Painter,
    val outlinedImage : Painter,
    val route : String
)
