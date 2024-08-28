package com.example.src_android.core.data.services

import com.example.src_android.core.domain.models.news.News
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiServices {
    @GET("/api/v1/news")
    suspend fun getNews() : Response<News>
}