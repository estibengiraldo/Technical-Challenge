package com.example.technicalchallenge.ui.products.detail_product

import com.example.technicalchallenge.domain.model.product.ProductModel

data class ProductUiState(
    val loading: Boolean,
    val product: ProductModel = ProductModel.emptyModel(),
    val isError: Boolean
)
