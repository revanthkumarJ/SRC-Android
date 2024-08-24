package com.example.src_android.features.home.presentaion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.R
import com.example.src_android.core.Event
import com.example.src_android.features.home.presentaion.homeComponents.EventCard

@Composable
fun UpcomingEvents() {
    val events = listOf(
        Event(
            image = R.drawable.src_logo,
            title = "Tech Conference 2024",
            date = "Aug 25, 2024",
            venue = "CSE DEPT.",
            description = "Join us for a day of insightful talks and networking with industry leaders.Join us for a day of insightful talks and networking with industry leaders",
        ),
        Event(
            image = R.drawable.src_logo,
            title = "Tech Conference 2024",
            date = "Aug 25, 2024",
            venue = "Computer center",
            description = "Join us for a day of insightful talks and networking with industry leaders.Join us for a day of insightful talks and networking with industry leaders",
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 15.dp)
    ) {
        Text(
            text = "Upcoming Events",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 9.dp),
            color = MaterialTheme.colorScheme.primary
        )
        LazyRow(modifier = Modifier.fillMaxWidth(0.95f)) {
            itemsIndexed(events) { index, item ->
                EventCard(
                    event = item
                )

            }
        }
    }
}