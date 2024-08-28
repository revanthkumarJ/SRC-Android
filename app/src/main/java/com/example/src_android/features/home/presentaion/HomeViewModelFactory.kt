package com.example.src_android.features.home.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.src_android.core.domain.repo.HomeRepo
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val homeRepo: HomeRepo) : ViewModelProvider
    .Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(homeRepo) as T
    }
}