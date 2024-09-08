package com.example.technicalchallenge.data.database.datasource.product

import com.example.technicalchallenge.data.database.dao.product.ProductDao
import com.example.technicalchallenge.data.database.model.entity.product.ProductDb
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductDbDataSource @Inject constructor(private val dao: ProductDao) {

    fun getAllProducts(): Flow<List<ProductDb>> = dao.getAllProducts()

    suspend fun insertProducts(products: List<ProductDb>) = dao.insert(products)
}
