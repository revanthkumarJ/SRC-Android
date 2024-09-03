package com.example.src_android.core.data.repo

import androidx.compose.runtime.MutableState
import com.example.src_android.core.data.services.UserServices
import retrofit2.http.FieldMap
import javax.inject.Inject

class UserRepo @Inject constructor(private val userServices: UserServices) {


    suspend fun loginUser(@FieldMap userPayload: Map<String, String>) = userServices.loginUser(userPayload)
    suspend fun signUpUser(@FieldMap userPayload: Map<String, String>)  = userServices.singUpUser(userPayload)

}