package com.example.src_android.features.about.di

import com.example.src_android.features.about.data.AboutRepo
import com.example.src_android.features.about.network.AboutApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AboutModule {

    @Provides
    @Singleton
    fun provideRetrofitServices(retrofit: Retrofit): AboutApiServices {
        return retrofit.create(AboutApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideAboutRepo(aboutApiServices: AboutApiServices):AboutRepo{
        return AboutRepo(aboutApiServices)
    }

}