package com.example.src_android.core.domain.models.domain

data class DomainsItem(
    val __v: Int,
    val _id: String,
    val contactForums: List<Any>,
    val createdAt: String,
    val description: String,
    val image: String,
    val name: String,
    val projects: List<String>,
    val resources: List<String>,
    val updatedAt: String
)