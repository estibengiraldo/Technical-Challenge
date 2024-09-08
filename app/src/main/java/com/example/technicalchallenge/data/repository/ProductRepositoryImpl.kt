package com.example.technicalchallenge.data.repository

import com.example.technicalchallenge.data.database.datasource.product.ProductDbDataSource
import com.example.technicalchallenge.data.database.model.entity.product.ProductDb
import com.example.technicalchallenge.domain.repository.product.ProductRepository
import com.example.technicalchallenge.data.remote.datasource.ProductDataSource
import com.example.technicalchallenge.domain.model.product.ProductModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductDataSource,
    private val databaseDataSource: ProductDbDataSource
) : ProductRepository {

    override fun getProducts(): Flow<List<ProductModel>> = remoteDataSource.getProducts()
        .map { products -> products.map { it.toProductModel() } }
        .catch {
            emitAll(
                databaseDataSource.getAllProducts()
                    .map { products-> products.map { it.toProductModel() } }
            )
        }

    override suspend fun insertProducts(products: List<ProductModel>) =
        databaseDataSource.insertProducts(products.map { ProductDb.fromProductModel(it) })
}
