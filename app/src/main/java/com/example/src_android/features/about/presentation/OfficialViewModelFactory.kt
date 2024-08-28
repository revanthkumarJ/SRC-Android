package com.example.src_android.features.about.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.src_android.core.data.repo.AboutRepo
import javax.inject.Inject

class OfficialViewModelFactory @Inject constructor(private val aboutRepo: AboutRepo) : ViewModelProvider
    .Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OfficialViewModel(aboutRepo) as T
    }
}