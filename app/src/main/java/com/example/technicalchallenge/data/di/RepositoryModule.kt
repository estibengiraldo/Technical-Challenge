package com.example.technicalchallenge.data.di

import com.example.technicalchallenge.data.repository.ProductRepositoryImpl
import com.example.technicalchallenge.domain.repository.product.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideProductRepository(repository: ProductRepositoryImpl): ProductRepository

}
