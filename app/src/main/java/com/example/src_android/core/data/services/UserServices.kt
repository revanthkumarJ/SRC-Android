package com.example.src_android.core.data.services

import androidx.compose.runtime.MutableState
import com.example.src_android.core.domain.models.user.User
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserServices {

    @FormUrlEncoded
    @POST("/api/v1/login")
    suspend fun loginUser(@FieldMap userPayload: Map<String, String>) :
            Response<User>
    @FormUrlEncoded
    @POST("/api/v1/signup")
    suspend fun singUpUser(@FieldMap fields: Map<String, String>) : Response<User>

}