package com.example.src_android.features.profile.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.src_android.features.profile.presentation.ProfileUIComponenents.EdtTextFields
import com.example.src_android.features.profile.presentation.ProfileUIComponenents.ProfileScreen

@Composable
fun Edt_Profile(modifier: Modifier) {
    Column(modifier=modifier.fillMaxSize().padding(vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        ProfileScreen()
        EdtTextFields()
    }
}