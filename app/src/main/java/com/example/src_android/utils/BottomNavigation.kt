package com.example.src_android.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.src_android.R
import com.example.src_android.core.BottomNavModel

@Composable
fun BottomNavigation(navHostController: NavHostController, onChange: (route: String) -> Unit) {
    val bottomBarImages = listOf(
        BottomNavModel(
            filledImage = painterResource(id = R.drawable.ic_home_filled),
            outlinedImage = painterResource(id = R.drawable.ic_home_outlined),
            route = "home"
        ),
        BottomNavModel(
            filledImage = painterResource(id = R.drawable.ic_project_filled),
            outlinedImage = painterResource(id = R.drawable.ic_project_outline),
            route = "projects"
        ),
        BottomNavModel(
            filledImage = painterResource(id = R.drawable.ic_calendar_filled),
            outlinedImage = painterResource(id = R.drawable.ic_calender_outlined),
            route = "events"
        ),

        )

    val navBackStackEntry = navHostController.currentBackStackEntryAsState()

    NavigationBar(containerColor = MaterialTheme.colorScheme.primaryContainer) {
        bottomBarImages.forEach {
            val selected = it.route == navBackStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = selected,
                onClick = { onChange(it.route) },
                icon = {
                    Image(
                        painter = if (selected) it.filledImage else it.outlinedImage,
                        contentDescription = "Route",
                        modifier = Modifier.size(25.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                ),
            )
        }
    }
}


