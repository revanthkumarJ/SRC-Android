package com.example.src_android.features.home.presentaion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Home(modifier: Modifier){
    HorizontalDivider(modifier = modifier, thickness = 5.dp, color = Color.Red)
    Text(
        text = "Welcome to Home Screen",
        color = MaterialTheme.colorScheme.primary,
        modifier =
        modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize()
    )
}