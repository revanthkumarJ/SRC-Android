package com.example.src_android.core.di.modules

import com.example.src_android.core.data.repo.DomainRepo
import com.example.src_android.core.data.services.DomainServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideDomainServices(retrofit: Retrofit) : DomainServices {
         return retrofit.create(DomainServices::class.java)
    }

    @Provides
    @Singleton
    fun provideDomainRepo(domainServices: DomainServices): DomainRepo {
        return DomainRepo(domainServices)
    }
}