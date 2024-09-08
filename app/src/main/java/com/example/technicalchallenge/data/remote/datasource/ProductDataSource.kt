package com.example.technicalchallenge.data.remote.datasource

import com.example.technicalchallenge.data.remote.exception.RemoteException
import com.example.technicalchallenge.data.remote.model.product.ProductRemote
import com.example.technicalchallenge.data.remote.service.ProductService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductDataSource @Inject constructor(private val service: ProductService) {

    @Throws(IOException::class)
    fun getProducts(): Flow<List<ProductRemote>> = flow {
        val response = service.getProducts()
        emit(
            if (response.isSuccessful) response.body()!!
            else throw RemoteException(response.code(), response.errorBody()?.string())
        )
    }
}
