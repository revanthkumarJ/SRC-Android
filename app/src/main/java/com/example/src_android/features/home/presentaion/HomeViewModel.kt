package com.example.src_android.features.home.presentaion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.src_android.core.data.repo.CarouselRepo
import com.example.src_android.core.data.repo.DomainRepo
import com.example.src_android.core.data.repo.NewsRepo
import com.example.src_android.core.domain.models.carousel.Carousel
import com.example.src_android.core.domain.models.domain.Domains
import com.example.src_android.core.domain.models.news.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepo: NewsRepo,
    private val domainRepo: DomainRepo,
    private val carouselRepo: CarouselRepo
) :
    ViewModel() {


    val carouselData =  MutableLiveData<Carousel?>()
    val newsData = MutableLiveData<News?>()
    val domainsData = MutableLiveData<Domains?>()
//    val isLoading = mutableStateOf(false)

    init {
        getNews()
        getDomains()
        getCarousels()
    }

    fun getNews() {
        viewModelScope.launch {
            try {
                val response = newsRepo.getNews()
                if (response.isSuccessful) {
                    newsData.value = response.body()
                    Log.d("arjun",newsData.value.toString())
                    newsData.let { it ->
                        it.map { news ->
                            news?.forEach {
                                Log.d("arjun", it.toString())
                            }
                        }
                    }
                } else {
                    newsData.postValue(null)
                }
            } catch (e: Exception) {
                Log.d("arjun", e.message.toString())
            }

        }
    }

    fun getDomains() {
        viewModelScope.launch {
            try {
                val response = domainRepo.getDomains()
                if (response.isSuccessful) {
                    domainsData.value = response.body()
                    Log.d("arjun",domainsData.value.toString())
                    domainsData.let {
                        it.map { domains ->
                            domains?.forEach { domainItem ->
                                Log.d("arjun", domainItem.toString())
                            }
                        }
                    }
                } else {
                    domainsData.postValue(null)
                }
            } catch (e: Exception) {
                Log.d("arjun", e.message.toString())
            }

        }
    }
    fun getCarousels() {
        viewModelScope.launch {
            try {
                val response = carouselRepo.getCarousels()
                if (response.isSuccessful) {
                    carouselData.value = response.body()
                    Log.d("arjun",carouselData.value.toString())
                    carouselData.let {
                        it.map { carousels ->
                            carousels?.forEach { carouselItem ->
                                Log.d("arjun", carouselItem.toString())
                            }
                        }
                    }
                } else {
                    carouselData.postValue(null)
                }
            } catch (e: Exception) {
                Log.d("arjun", e.message.toString())
            }

        }
    }

}