package com.example.src_android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.MakeCRUI
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.MakeCoordinatorUI
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.OfficialUI
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.TestimonalInputUI
import com.example.src_android.features.Admin.presentation.SubPages.HomeUI.Carousel
import com.example.src_android.features.Admin.presentation.SubPages.HomeUI.Domain
import com.example.src_android.features.Admin.presentation.SubPages.HomeUI.NewsUI
import com.example.src_android.features.About.presentation.About
import com.example.src_android.features.home.presentaion.screens.Home
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
       composable("about"){
           About(modifier = modifier)
           onChange("about")
       }

       composable("carousel"){
           Carousel(modifier = modifier)
           onChange("carousel")
       }
       composable("domain"){
           Domain(modifier = modifier)
           onChange("domain")
       }
       composable("news"){
           NewsUI(modifier = modifier)
           onChange("news")
       }
       composable("official"){
           OfficialUI(modifier = modifier)
           onChange("official")
       }
       composable("testimonial"){
           TestimonalInputUI(modifier = modifier)
           onChange("testimonial")
       }
       composable("make-CR"){
           MakeCRUI(modifier = modifier)
           onChange("make-CR")
       }
       composable("coordinator"){
           MakeCoordinatorUI(modifier = modifier)
           onChange("coordinator")
       }
   }
}