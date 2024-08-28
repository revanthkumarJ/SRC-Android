package com.example.src_android.core.di.modules

import com.example.src_android.core.data.repo.NewsRepo
import com.example.src_android.core.data.services.NewsApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsRetrofitServices(retrofit: Retrofit) : NewsApiServices {
        return retrofit.create(NewsApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepo(newsApiServices: NewsApiServices) : NewsRepo {
        return NewsRepo(newsApiServices)
    }
}