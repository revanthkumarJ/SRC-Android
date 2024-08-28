package com.example.src_android.core.data.services

import com.example.src_android.core.domain.models.domain.Domains
import retrofit2.Response
import retrofit2.http.GET

interface DomainServices {
    @GET("/api/v1/domains")
    suspend fun getDomains() : Response<Domains>

}

