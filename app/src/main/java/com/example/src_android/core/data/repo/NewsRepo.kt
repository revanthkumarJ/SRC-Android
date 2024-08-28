package com.example.src_android.core.data.repo

import com.example.src_android.core.data.services.NewsApiServices
import javax.inject.Inject

class NewsRepo @Inject constructor(private val newsApiServices: NewsApiServices) {
    suspend fun getNews() = newsApiServices.getNews()
}