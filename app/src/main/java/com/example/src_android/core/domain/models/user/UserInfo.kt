package com.example.src_android.core.domain.models.user

data class UserInfo(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val isCr: Boolean,
    val isVerified: Boolean,
    val name: String,
    val password: String,
    val role: String,
    val updatedAt: String
)