package com.example.src_android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.src_android.Admin.SubPages.HomeUI.Carousel
import com.example.src_android.Admin.SubPages.HomeUI.Domain
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.MakeCRUI
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.MakeCoordinatorUI
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.Official
import com.example.src_android.features.Admin.presentation.SubPages.AboutUsUI.Testimonial
import com.example.src_android.features.Admin.presentation.SubPages.Events.UpComingEventUI
import com.example.src_android.features.Admin.presentation.SubPages.HomeUI.News
import com.example.src_android.features.about.presentation.About
import com.example.src_android.features.about.presentation.OfficialViewModel
import com.example.src_android.features.home.presentaion.screens.Home
import com.example.src_android.features.events.presentation.Events
import com.example.src_android.features.home.presentaion.HomeViewModel
import com.example.src_android.features.profile.presentation.screens.Edt_Profile
import com.example.src_android.features.profile.presentation.screens.Profile
import com.example.src_android.features.projects.presentation.Projects

@Composable
fun Navigation(modifier: Modifier, navHostController: NavHostController,officialViewModel: OfficialViewModel,homeViewModel: HomeViewModel,onChange:(route : String)
->Unit){
   NavHost(navController = navHostController, startDestination = "home"){
       composable("home"){
           Home(modifier,homeViewModel)
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
           About(modifier = modifier, officialViewModel)
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
           News(modifier = modifier)
           onChange("news")
       }
       composable("official"){
           Official(modifier = modifier)
           onChange("official")
       }
       composable("testimonial"){
           Testimonial(modifier = modifier)
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