package com.example.src_android.features.about.network

import com.example.src_android.features.about.data.model.Officials
import retrofit2.http.GET
import retrofit2.Response
interface AboutApiServices {
    @GET("/api/v1/officials")
    suspend fun getOfficials() : Response<Officials>
}