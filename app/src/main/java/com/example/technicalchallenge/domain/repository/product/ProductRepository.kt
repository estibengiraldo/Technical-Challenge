package com.example.technicalchallenge.domain.repository.product

import com.example.technicalchallenge.domain.model.product.ProductModel
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(): Flow<List<ProductModel>>

    suspend fun insertProducts(products: List<ProductModel>)

    fun getProduct(id: Int): Flow<ProductModel>
}
