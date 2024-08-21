package com.example.src_android.features.home.presentaion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.src_android.R
import com.example.src_android.core.News
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.features.home.presentaion.homeComponents.NewsCardItem


@Composable
fun LatestNews() {
    val news = listOf(
        News(R.drawable.src_logo, "This is title", "This is description.This is description.This " +
                "is description.This is description.This is description.This is description.This " +
                "is description.This is description"),
        News(R.drawable.krishna, "This is title", "This is description"),
        News(R.drawable.src_logo, "This is title", "This is description"),
        News(R.drawable.src_logo, "This is title", "This is description"),
        News(R.drawable.src_logo, "This is title", "This is description")
    )


    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 15.dp)
    ) {
        Text(
            text = "Latest News",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier.padding(start = 15.dp),
            color = MaterialTheme.colorScheme.primary
        )
        LazyRow(modifier = Modifier.fillMaxWidth(0.95f)) {
            itemsIndexed(news) { index, item ->
                NewsCardItem(news = item)
            }
        }
    }


}

