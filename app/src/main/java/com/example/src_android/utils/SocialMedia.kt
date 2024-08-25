package com.example.src_android.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.R
import com.example.src_android.features.profile.presentation.ProfileUIComponenents.ImageButton

@Composable
fun SocialMedia() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 25.dp)
    ) {
        Text(
            text = "Computer Science Dept - RGUKT RKV",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 25.dp)
        )
        Text(
            text = "Follow us in Social to get Updates",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 15.dp)
        )
        Row(
            modifier = Modifier.padding(top = 25.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ImageButton(
                painter = painterResource(id = R.drawable.linkdein_white),
                url = "https://github.com/Nagarjuna0033/SRC-Android",
                contentDescription = "linkedin link",
                size = 35
            )
            ImageButton(
                painter = painterResource(id = R.drawable.github_white),
                url = "https://github.com/Nagarjuna0033/SRC-Android",
                contentDescription = "github link",
                size = 35
            )
            ImageButton(
                painter = painterResource(id = R.drawable.linkdein_white),
                url = "https://github.com/Nagarjuna0033/SRC-Android",
                contentDescription = "instagram link",
                size = 35
            )
        }
    }
}