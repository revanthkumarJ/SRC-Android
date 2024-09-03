package com.example.src_android.core.di.modules

import com.example.src_android.core.data.repo.UserRepo
import com.example.src_android.core.data.services.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

   @Provides
   @Singleton
   fun provideUserServices(retrofit: Retrofit) : UserServices{
       return retrofit.create(UserServices::class.java)
   }

    @Provides
    @Singleton
    fun provideUserRepo(userServices : UserServices) : UserRepo{
        return UserRepo(userServices)
    }


}