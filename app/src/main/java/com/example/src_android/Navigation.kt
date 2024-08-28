package com.example.src_android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.src_android.Admin.AdminUI.AdminPage
import com.example.src_android.Admin.SubPages.AboutUsUI.MakeCRUI
import com.example.src_android.Admin.SubPages.AboutUsUI.MakeCoordinatorUI
import com.example.src_android.Admin.SubPages.AboutUsUI.Official
import com.example.src_android.Admin.SubPages.AboutUsUI.Testimonal
import com.example.src_android.Admin.SubPages.Events.UpComingEventUI
import com.example.src_android.Admin.SubPages.HomeUI.Carousel
import com.example.src_android.Admin.SubPages.HomeUI.Domain
import com.example.src_android.Admin.SubPages.HomeUI.News
import com.example.src_android.features.About.About
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
       composable("admin"){
           AdminPage(navController=navHostController,modifier = modifier)
           onChange("admin")
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
           News(modifier = modifier)
           onChange("news")
       }
       composable("official"){
           Official(modifier = modifier)
           onChange("official")
       }
       composable("testimonial"){
           Testimonal(modifier = modifier)
           onChange("testimonial")
       }
       composable("makecr"){
           MakeCRUI(modifier = modifier)
           onChange("makecr")
       }
       composable("makecoordinator"){
           MakeCoordinatorUI(modifier = modifier)
           onChange("makecoordinator")
       }
       composable("upcomingevent"){
           UpComingEventUI(modifier = modifier)
           onChange("upcomingevent")
       }


   }
}