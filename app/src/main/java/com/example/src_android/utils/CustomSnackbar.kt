package com.example.src_android.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color

@Composable
fun CustomSnackbar(
    snackbarData: String?,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    snackbarData?.let {
        Box(
            modifier = modifier
                .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.small)
                .border(
                    3.dp, Color(8, 96, 168),
                    MaterialTheme.shapes.small
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                icon()
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = snackbarData,
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }
    }

}


