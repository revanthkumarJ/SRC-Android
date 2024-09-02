package com.example.src_android.features.login.presentation.loginViewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.src_android.core.data.repo.UserRepo
import retrofit2.Retrofit
import javax.inject.Inject

class LogInViewModelFactory @Inject constructor(
    private val userRepo: UserRepo, private val
    application: Application,
    private val retrofit: Retrofit
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LogInViewModel(userRepo, application,retrofit) as T
    }

}