package com.example.src_android.features.login.presentation

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.features.login.presentation.loginViewModel.LogInViewModel
import com.example.src_android.utils.Loader

@Composable
fun Login(modifier: Modifier, logInViewModel: LogInViewModel) {
    val btnDisable by logInViewModel.btnDisable.observeAsState(true)

    DisposableEffect(Unit) {
        onDispose {
            // Clear email and password when the composable is removed
            logInViewModel.email.value = ""
            logInViewModel.password.value = ""
        }
    }

    Box(
        modifier = modifier
            .padding(start = 15.dp, top = 25.dp)
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "To get started First enter Email",
                fontSize = 25.sp,
                color = MaterialTheme
                    .colorScheme
                    .primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 75.dp),
                lineHeight
                = 35.sp
            )

            OutlinedTextField(
                label = { Text(text = "Email") }, value = logInViewModel.email.value,
                onValueChange = { logInViewModel.email.value = it }, maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 15.dp,
                        top = 15.dp,
                        end = 15.dp
                    ),
                colors = OutlinedTextFieldDefaults.colors
                    (
                    focusedBorderColor
                    = Color(8, 96, 152),
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                    focusedLabelColor = Color(8, 96, 152),
                ),
            )
            OutlinedTextField(
                label = { Text(text = "Password") }, value = logInViewModel.password.value,
                onValueChange =
                { logInViewModel.password.value = it },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 15.dp,
                        top = 15.dp,
                        end = 15.dp
                    ),
                colors = OutlinedTextFieldDefaults.colors
                    (
                    focusedBorderColor
                    = Color(8, 96, 152),
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                    focusedLabelColor = Color(8, 96, 152),
                ),
            )
//            8 96 168
//            7 87 152
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        end = 25.dp, bottom =
                        25.dp
                    )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize(), contentAlignment = Alignment
                        .BottomStart
                ) {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        shape =
                        RoundedCornerShape(
                            5.dp
                        )
                    ) {
                        Text(
                            text = "Forgot password?",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,

                            )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize(), contentAlignment = Alignment
                        .BottomEnd
                ) {
                    OutlinedButton(
                        enabled = btnDisable,
                        onClick = { logInViewModel.getUserByEmail() },
                        shape =
                        RoundedCornerShape(
                            5.dp
                        ), colors =
                        ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        if (btnDisable) {
                            Text(
                                text = "Login",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color =
                                MaterialTheme.colorScheme.primaryContainer
                            )
                        } else {
                            Loader()
                        }

                    }
                }
            }
        }
    }
}