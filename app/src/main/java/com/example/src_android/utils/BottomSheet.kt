package com.example.src_android.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.core.AdminOptions
import com.example.src_android.core.News

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
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme
                        .colorScheme.primaryContainer
                ),
            ) {
                Text(
                    text = "Logout", fontSize = 21.sp, color = MaterialTheme.colorScheme
                        .primary, modifier = Modifier.padding(5.dp)
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsBottomSheet(
    sheetState: SheetState, news: News, showBottomSheet: () -> Unit,
) {
    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        onDismissRequest = {
            showBottomSheet()
        },
        modifier = Modifier.fillMaxHeight(),

        sheetState = sheetState
    ) {
        // Sheet content
        Column(
            modifier = Modifier.padding(
                start = 15.dp,
                end = 15.dp
            ),
            verticalArrangement =
            Arrangement
                .Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = news.title, color = MaterialTheme.colorScheme.primary,
                fontWeight =
                FontWeight.Bold,
                fontSize = 17.sp,
            )
            Text(
                text = news.description,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 15.sp,
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminBottomSheet(
    scope: CoroutineScope, sheetState: SheetState, adminOptionList: List<AdminOptions>,
    onClick: (String) ->
    Unit,
    showAdminBottomSheet : ()-> Unit
) {
    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        onDismissRequest = {
            showAdminBottomSheet()
        },

        sheetState = sheetState
    ) {
        // Sheet content
        Column(
            modifier = Modifier.padding(
                start = 15.dp,
                end = 15.dp
            ),
            verticalArrangement =
            Arrangement
                .Center,
            horizontalAlignment = Alignment.Start
        ) {
            adminOptionList.map {
                OutlinedButton(
                    onClick = {
                        onClick(it.route)
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showAdminBottomSheet()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme
                            .colorScheme.primaryContainer
                    ),
                ) {
                    Text(
                        text = it.option, fontSize = 21.sp, color = MaterialTheme.colorScheme
                            .primary, modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}