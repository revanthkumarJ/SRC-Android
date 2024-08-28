package com.example.src_android.features.home.presentaion

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.src_android.core.News
import com.example.src_android.core.data.repo.NewsRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val newsRepo: NewsRepo) : ViewModel(){

    val officialLiveData = MutableLiveData<News?>()
    val isLoading = mutableStateOf(false)
    init {
        getNews()
    }
    fun getNews() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = newsRepo.getNews()
                if (response.isSuccessful) {
                    officialLiveData.postValue(response.body())
                    officialLiveData.let {
                        Log.d("arjun",it.value.toString())
                        isLoading.value = false
                    }

                } else {
                    officialLiveData.postValue(null)
                    isLoading.value = false
                }

            }catch (e : Exception){
                Log.d("arjun",e.message.toString())
                isLoading.value = false
            }

        }
    }

}