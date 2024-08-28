package com.example.src_android.core.data.services

import com.example.src_android.core.domain.models.carousel.Carousel
import retrofit2.Response
import retrofit2.http.GET

interface CarouselServices {
    @GET("/api/v1/carousel")
    suspend fun getCarousels() : Response<Carousel>

}