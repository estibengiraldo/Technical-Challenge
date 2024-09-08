package com.example.technicalchallenge.data.di

import android.content.Context
import androidx.room.Room
import com.example.technicalchallenge.data.database.AppDatabase
import com.example.technicalchallenge.data.database.dao.product.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "StoreDatabase")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideWarehouseDao(database: AppDatabase): ProductDao = database.productDao()
}
