package com.example.src_android.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(scope: CoroutineScope, sheetState: SheetState, showBottomSheet: () -> Unit) {

    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        onDismissRequest = {
            showBottomSheet()
        },

        sheetState = sheetState
    ) {
        // Sheet content
//            Button(onClick = {
//                scope.launch { sheetState.hide() }.invokeOnCompletion {
//                    if (!sheetState.isVisible) {
//                        showBottomSheet()
//                    }
//                }
//            }) {
//                Text("Hide bottom sheet")
//            }
        Column(
            modifier = Modifier.padding(
                start = 15.dp,
                end = 15.dp
            ), verticalArrangement =
            Arrangement
                .Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedButton(
                onClick = { scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet()
                    }
                } },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 25.dp),
//                    .border(
//                        1.dp, color = MaterialTheme.colorScheme.primary,
//                        shape =
//                        RoundedCornerShape(25.dp)
//                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme
                        .colorScheme.primaryContainer
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Logout", fontSize = 21.sp, color = MaterialTheme.colorScheme
                        .primary
                )
            }

        }
    }
}
