package com.example.src_android.features.home.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.src_android.core.data.repo.NewsRepo
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val newsRepo: NewsRepo) : ViewModelProvider
    .Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(newsRepo) as T
    }
}