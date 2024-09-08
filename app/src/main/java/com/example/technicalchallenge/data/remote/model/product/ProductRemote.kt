package com.example.technicalchallenge.data.remote.model.product

import com.example.technicalchallenge.domain.model.product.ProductModel
import com.google.gson.annotations.SerializedName
data class ProductRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Double,
    @SerializedName("images") val images: List<String?>,
) {
    fun toProductModel(): ProductModel = ProductModel(id.toLong(), title, description, price, images.get(0)?:"")
}