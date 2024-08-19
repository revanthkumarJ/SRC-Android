
package com.example.src_android.features.profile.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.src_android.features.profile.presentation.ProfileUIComponenents.ProfileBottomCard
import com.example.src_android.features.profile.presentation.ProfileUIComponenents.ProfileTop

@Composable
fun Profile(modifier: Modifier) {
    Column(modifier=modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        ProfileTop(image = "", profile_name = "Revanth Kumar J")
        ProfileBottomCard()
    }
