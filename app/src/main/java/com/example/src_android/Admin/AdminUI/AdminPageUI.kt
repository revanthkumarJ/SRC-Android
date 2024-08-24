package com.example.src_android.Admin.AdminUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.src_android.R

@Composable
fun AdminPage(navController: NavController, modifier: Modifier)
{
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Home Section
        Text(text = "Home", fontSize = 24.sp, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            NavigationBadge(iconRes = R.drawable.gfg_icon_white, label = "Carousel", onClick = { navController.navigate("carousel") })
            NavigationBadge(iconRes = R.drawable.gfg_icon_white, label = "Domain", onClick = { navController.navigate("domain") })
            NavigationBadge(iconRes = R.drawable.gfg_icon_white, label = "News", onClick = { navController.navigate("news") })
        }

        // About Us Section
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "About Us", fontSize = 24.sp, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            NavigationBadge(iconRes = R.drawable.github_white, label = "Official Details", onClick = { navController.navigate("official") })
            NavigationBadge(iconRes = R.drawable.src_logo, label = "Coordinator Details", onClick = { navController.navigate("makecoordinator") })
            NavigationBadge(iconRes = R.drawable.ic_dark_mode, label = "Testimonials", onClick = { navController.navigate("testimonial") })
            NavigationBadge(iconRes = R.drawable.leetcode_white, label = "Make CR", onClick = { navController.navigate("makecr") })
        }

        // Events Section
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Events", fontSize = 24.sp, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            NavigationBadge(iconRes = R.drawable.linkdein_white, label = "Completed Events", onClick = { navController.navigate("home") })
            NavigationBadge(iconRes = R.drawable.ic_user_options, label = "Upcoming Events", onClick = { navController.navigate("home") })
        }

        // Other Section
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Other", fontSize = 24.sp, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            NavigationBadge(iconRes = R.drawable.ic_light_mode, label = "Projects", onClick = { navController.navigate("home") })
            NavigationBadge(iconRes = R.drawable.gfg_icon_white, label = "Resources", onClick = { navController.navigate("home") })
            NavigationBadge(iconRes = R.drawable.gfg_icon_white, label = "Contact Forum", onClick = { navController.navigate("home") })
            NavigationBadge(iconRes = R.drawable.gfg_icon_white, label = "Feedback", onClick = { navController.navigate("home") })
        }
    }
}

@Composable
fun NavigationBadge(iconRes: Int, label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = label, fontSize = 12.sp, color = Color.White)
        }
    }
}