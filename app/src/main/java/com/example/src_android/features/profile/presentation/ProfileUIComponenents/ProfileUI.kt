package com.example.src_android.features.profile.presentation.ProfileUIComponenents

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.R


@Composable
fun ProfileTop(image: String, profile_name: String) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = R.drawable.src_logo),
            contentDescription = "profile_image",
            modifier = Modifier
                .size(250.dp, 250.dp)
                .clip(RoundedCornerShape(50)),
            contentScale = ContentScale.Crop,
        )
        Text(text = profile_name,fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

    }
}

@Composable
fun ProfileBottomCard()
{
    val containerColor = if (MaterialTheme.colorScheme.primaryContainer == Color.Black) {
        Color(0xFF1A1A1A)
    } else {
        Color(0xFFFAF9F6)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 25.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor =containerColor)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // First row: Name
            Text(
                text = "John Doe",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Second row: Email
            Text(
                text = "john.doe@example.com",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Third row: 4 Images
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ImageButton(
                    painter = painterResource(id = R.drawable.linkdein_white),
                    url = "https://github.com/revanthkumarJ/SRC-Android",
                    contentDescription = "Image 1",
                    size = 35
                )

                ImageButton(
                    painter = painterResource(id = R.drawable.github_white),
                    url = "https://example.com/link2",
                    contentDescription = "Image 2",
                    size = 35
                )

                ImageButton(
                    painter = painterResource(id = R.drawable.gfg_icon_white),
                    url = "https://example.com/link3",
                    contentDescription = "Image 3",
                    size = 35
                )

                ImageButton(
                    painter = painterResource(id = R.drawable.leetcode_white),
                    url = "https://example.com/link4",
                    contentDescription = "Image 4",
                    size = 35
                )
            }
        }
    }
}

@Composable
fun ImageButton(painter: Painter, url: String, contentDescription: String?, size:Int) {
    val context = LocalContext.current

    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier
            .size(size.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            },
        colorFilter = ColorFilter.tint(
            if(MaterialTheme.colorScheme.primaryContainer==Color.Black)
            Color.White
            else
            Color.Black
        )
    )
}