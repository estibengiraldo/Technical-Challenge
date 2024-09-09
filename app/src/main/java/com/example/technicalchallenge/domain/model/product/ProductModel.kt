package com.example.technicalchallenge.domain.model.product

import com.example.technicalchallenge.data.database.model.entity.product.ProductDb

data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val images: String
){
    companion object {

        fun emptyModel() = ProductModel(
            0,
            "product.title",
           "",
            0.0,
            ""
        )
    }
}
