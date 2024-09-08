package com.example.technicalchallenge.domain.model.product

data class ProductModel(
    val id: Long,
    val title: String,
    val description: String,
    val price: Double,
    val images: String
)
