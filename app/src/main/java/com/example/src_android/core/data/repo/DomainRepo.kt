package com.example.src_android.core.data.repo

import com.example.src_android.core.data.services.DomainServices
import javax.inject.Inject

class DomainRepo @Inject constructor(private val domainServices: DomainServices) {

    suspend fun getDomains() = domainServices.getDomains()
}