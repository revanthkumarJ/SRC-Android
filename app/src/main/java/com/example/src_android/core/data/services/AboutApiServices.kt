package com.example.src_android.core.data.services

import com.example.src_android.core.domain.models.official.Officials
import retrofit2.http.GET
import retrofit2.Response
interface AboutApiServices {
    @GET("/api/v1/officials")
    suspend fun getOfficials() : Response<Officials>

}