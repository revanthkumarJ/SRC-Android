package com.example.src_android.features.home.presentaion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.features.home.presentaion.HomeViewModel
import com.example.src_android.features.home.presentaion.homeComponents.NewsCardItem
import com.example.src_android.utils.DecodeBase64ToBitmap


@Composable
fun LatestNews(homeViewModel: HomeViewModel) {


    val news by homeViewModel.newsData.observeAsState()
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

            news?.let{it->
                it.map { newsItem ->
                    val decoder = DecodeBase64ToBitmap()
                    val bitmap = decoder.decodeBase64ToBitmap(it.first().image)
                    item {
                        NewsCardItem(news = newsItem,image = bitmap)
                    }
                }
            }
        }
    }
}

