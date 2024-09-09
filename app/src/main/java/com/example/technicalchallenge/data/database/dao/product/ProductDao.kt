package com.example.technicalchallenge.data.database.dao.product

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.technicalchallenge.data.database.model.entity.product.ProductDb
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Upsert(entity = ProductDb::class)
    suspend fun insert(products: List<ProductDb>)

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<ProductDb>>

    @Query("SELECT * FROM product WHERE id=:id")
    fun getProduct(id: Int): Flow<ProductDb>
}
