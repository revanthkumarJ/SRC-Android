package com.example.src_android.features.home.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.src_android.core.data.repo.CarouselRepo
import com.example.src_android.core.data.repo.DomainRepo
import com.example.src_android.core.data.repo.NewsRepo
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val newsRepo: NewsRepo,private val
domainRepo : DomainRepo,private val carouselRepo : CarouselRepo
) :
    ViewModelProvider
    .Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(newsRepo,domainRepo,carouselRepo) as T
    }
}