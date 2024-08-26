package com.example.src_android.features.About.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.R
import com.example.src_android.features.profile.presentation.ProfileUIComponenents.ImageButton


@Composable
fun About(modifier: Modifier) {
    val coordinators = listOf(
        AboutData(
            image = "",
            name = "Revanth",
            isAdmin = true,
            isCoordinator = true,
            linkdein = "",
            gfg = "",
            leetcode = "",
            github = ""
        ),
        AboutData(
            image = "",
            name = "Arjun",
            isAdmin = false,
            isCoordinator = true,
            linkdein = "",
            gfg = "",
            leetcode = "",
            github = ""
        )
        ,
        AboutData(
            image = "",
            name = "Arjun",
            isAdmin = false,
            isCoordinator = true,
            linkdein = "",
            gfg = "",
            leetcode = "",
            github = ""
        ),
        AboutData(
            image = "",
            name = "Arjun",
            isAdmin = false,
            isCoordinator = true,
            linkdein = "",
            gfg = "",
            leetcode = "",
            github = ""
        ),
        AboutData(
            image = "",
            name = "Arjun",
            isAdmin = false,
            isCoordinator = true,
            linkdein = "",
            gfg = "",
            leetcode = "",
            github = ""
        ),
        AboutData(
            image = "",
            name = "Arjun",
            isAdmin = false,
            isCoordinator = true,
            linkdein = "",
            gfg = "",
            leetcode = "",
            github = ""
        )
    )

    LazyColumn(
        modifier = modifier.padding(horizontal = 10.dp)
    ) {
        item {
            Text(
                text = "Welcome to the SRC (Student Recreation Center), a dynamic club initiated by the Computer Science department of RGUKT RK Valley in 2024. Our mission is to foster increased interaction between seniors and juniors, promoting a culture of mutual learning, collaboration, and support within our college community.Welcome to the SRC (Student Recreation Center), a dynamic club initiated by the Computer Science department of RGUKT RK Valley in 2024. Our mission is to foster increased interaction between seniors and juniors, promoting a culture of mutual learning, collaboration, and support within our college community.",
                modifier = Modifier.padding(horizontal = 5.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Our Coordinators", fontSize = 28.sp, modifier = Modifier.padding(start = 10.dp))
            Spacer(modifier = Modifier.height(10.dp))
        }

        itemsIndexed(coordinators) { index,coordinator ->
            AboutCoordinatorItem(
                image = coordinator.image,
                name = coordinator.name,
                isAdmin = coordinator.isAdmin,
                isCoordinator = coordinator.isCoordinator,
                linkdein = coordinator.linkdein,
                gfg = coordinator.gfg,
                leetcode = coordinator.leetcode,
                github = coordinator.github
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun AboutCoordinatorItem(image:String,name:String,isAdmin:Boolean,isCoordinator:Boolean,linkdein:String,gfg:String,leetcode:String,github:String)
{

    val containerColor = if (MaterialTheme.colorScheme.primaryContainer == Color.Black) {
        Color(0xFF1A1A1A)
    } else {
        Color(0xFFFAF9F6)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(containerColor, RoundedCornerShape(15.dp))
            .padding(horizontal = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                Text(text = name, fontSize = 19.sp, modifier = Modifier.padding(start = 15.dp))
                Spacer(modifier = Modifier.height(7.dp))

                if (isAdmin) {
                    Text(text = "Admin", modifier = Modifier.padding(start = 15.dp))
                    Spacer(modifier = Modifier.height(7.dp))
                }
                if (isCoordinator) {
                    Text(text = "Coordinator", modifier = Modifier.padding(start = 15.dp))
                    Spacer(modifier = Modifier.height(7.dp))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ImageButton(
                        painter = painterResource(id = R.drawable.linkdein_white),
                        url = "https://github.com/revanthkumarJ/SRC-Android",
                        contentDescription = "Image 1",
                        size = 30
                    )

                    ImageButton(
                        painter = painterResource(id = R.drawable.github_white),
                        url = "https://example.com/link2",
                        contentDescription = "Image 2",
                        size = 30
                    )

                    ImageButton(
                        painter = painterResource(id = R.drawable.gfg_icon_white),
                        url = "https://example.com/link3",
                        contentDescription = "Image 3",
                        size = 30
                    )

                    ImageButton(
                        painter = painterResource(id = R.drawable.leetcode_white),
                        url = "https://example.com/link4",
                        contentDescription = "Image 4",
                        size = 30
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.src_logo),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(50))
                ,
                contentScale = ContentScale.Crop
            )
        }
    }

}