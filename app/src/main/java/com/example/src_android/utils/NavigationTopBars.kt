package com.example.src_android.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.src_android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopHomeBar(onClick:()->Unit){
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),

        navigationIcon = {
            IconButton(onClick = { onClick() }, modifier = Modifier.padding(start = 15.dp)) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "profile " +
                            "Image",
                    modifier = Modifier.size(31.dp)
                )
            }
        },
        title = {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.src_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(95.dp)
                )

            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherTopBar(onClick: () -> Unit){
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),

        navigationIcon = {
            IconButton(onClick = { onClick() }, modifier = Modifier.padding(start = 15.dp)) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "navigate Back",
                    modifier = Modifier.size(31.dp)
                )
            }
        },
        title = {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.src_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(95.dp)
                )

            }
        }
    )
}