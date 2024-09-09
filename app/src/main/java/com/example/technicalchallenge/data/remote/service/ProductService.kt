package com.example.technicalchallenge.data.remote.service

import com.example.technicalchallenge.data.remote.model.product.ProductRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("api/v1/products")
    suspend fun getProducts(
    ): Response<List<ProductRemote>>

    @GET("api/v1/products/{id}")
    suspend fun getProduct(
        @Path("id") id: Int
    ): Response<ProductRemote>
}