package com.example.src_android.features.Buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FloatingPointButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        contentAlignment = Alignment.BottomEnd
    ) {

        FloatingActionButton(
            onClick = onClick,
            containerColor = Color.LightGray,
            shape = RoundedCornerShape(50.dp),
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 15.dp),
            modifier = Modifier.size(61.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Edit",
                tint = Color.White,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}