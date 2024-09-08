package com.example.technicalchallenge.data.database

import androidx.room.Database
import androidx.room.RewriteQueriesToDropUnusedColumns
import androidx.room.RoomDatabase
import com.example.technicalchallenge.data.database.dao.product.ProductDao
import com.example.technicalchallenge.data.database.model.entity.product.ProductDb

@Database(
    entities = [
        ProductDb::class,
    ],
    version = 1
)

@RewriteQueriesToDropUnusedColumns
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}
