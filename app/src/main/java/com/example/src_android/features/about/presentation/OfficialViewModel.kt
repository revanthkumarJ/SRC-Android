package com.example.src_android.features.about.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.src_android.features.about.data.model.Officials
import com.example.src_android.features.about.data.AboutRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfficialViewModel @Inject constructor(private val aboutRepo: AboutRepo) : ViewModel() {

    val officialLiveData = MutableLiveData<Officials?>()
    val isLoading = mutableStateOf(false)
    init {
        getOfficials()
    }
    fun getOfficials() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = aboutRepo.getOfficials()
                if (response.isSuccessful) {
                    officialLiveData.postValue(response.body())
                    officialLiveData.let {
                        Log.d("officialInfo",it.value.toString())
                        isLoading.value = false
                    }

                } else {
                    officialLiveData.postValue(null)
                    isLoading.value = false
                }

            }catch (e : Exception){
                Log.d("officialInfo",e.message.toString())
                isLoading.value = false
            }

        }
    }

}