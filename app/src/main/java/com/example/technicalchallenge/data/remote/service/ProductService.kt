package com.example.technicalchallenge.data.remote.service

import com.example.technicalchallenge.data.remote.model.product.ProductRemote
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("api/v1/products")
    suspend fun getProducts(
    ): Response<List<ProductRemote>>
}