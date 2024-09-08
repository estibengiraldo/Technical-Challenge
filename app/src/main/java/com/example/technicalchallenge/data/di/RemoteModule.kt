package com.example.technicalchallenge.data.di

import com.example.technicalchallenge.data.remote.service.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    companion object {

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.escuelajs.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        @Provides
        fun provideLoginService(retrofit: Retrofit): ProductService =
            retrofit.create(ProductService::class.java)
    }
}