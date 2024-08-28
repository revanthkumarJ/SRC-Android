package com.example.src_android.core.di.modules

import com.example.src_android.core.data.repo.CarouselRepo
import com.example.src_android.core.data.services.CarouselServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CarouselModule {
    @Provides
    @Singleton
    fun provideCarouselServices(retrofit: Retrofit) : CarouselServices {
        return retrofit.create(CarouselServices::class.java)
    }


    @Provides
    @Singleton
    fun provideCarouselRepo(carouselServices : CarouselServices) : CarouselRepo{
        return CarouselRepo(carouselServices)
    }
}