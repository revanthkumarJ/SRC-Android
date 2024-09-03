package com.example.src_android.core.domain.models.user

data class User(
    val data: Data?,
    val err: Any?,
    val message: String,
    val success: Boolean
)