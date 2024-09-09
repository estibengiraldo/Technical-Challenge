package com.example.technicalchallenge.ui.products.list_products

import com.example.technicalchallenge.domain.model.product.ProductModel

data class ListProductsUiState(
    val loading: Boolean,
    val listProducts: List<ProductModel>,
    val isError: Boolean
)
