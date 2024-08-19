package com.example.src_android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.src_android.features.home.presentaion.Home
import com.example.src_android.features.events.presentation.Events
import com.example.src_android.features.profile.presentation.screens.Edt_Profile
import com.example.src_android.features.profile.presentation.screens.Profile
import com.example.src_android.features.projects.presentation.Projects

@Composable
fun Navigation(modifier: Modifier, navHostController: NavHostController,onChange:(route : String)
->Unit){
   NavHost(navController = navHostController, startDestination = "home"){
       composable("home"){
           Home(modifier)
           onChange("home")
       }
       composable("profile"){
           Profile(modifier)
           onChange("profile")
       }
       composable("edt_profile"){
           Edt_Profile(modifier)
           onChange("edt_profile")
       }
       composable("events"){
           Events(modifier = modifier)
           onChange("events")
       }
       composable("projects"){
           Projects(modifier = modifier)
           onChange("projects")
       }
   }
}