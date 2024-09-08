package com.example.technicalchallenge.domain.usecase.product

import com.example.technicalchallenge.core.usecase.UseCaseFlow
import com.example.technicalchallenge.domain.model.product.ProductModel
import com.example.technicalchallenge.domain.repository.product.ProductRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository,
) : UseCaseFlow<List<ProductModel>, Unit>() {

    override fun run(params: Unit?): Flow<List<ProductModel>> =
        repository.getProducts().flowOn(context = IO)
}
