package com.example.src_android.core.data.repo

import com.example.src_android.core.data.services.CarouselServices
import javax.inject.Inject

class CarouselRepo @Inject constructor(private val carouselServices: CarouselServices) {

    suspend fun getCarousels() = carouselServices.getCarousels()
}