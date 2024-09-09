package com.example.technicalchallenge.domain.usecase.product

import com.example.technicalchallenge.core.usecase.UseCaseFlow
import com.example.technicalchallenge.domain.model.product.ProductModel
import com.example.technicalchallenge.domain.repository.product.ProductRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import java.security.InvalidParameterException
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository,
) : UseCaseFlow<ProductModel, GetProductUseCase.Parameters>() {

    @Throws(InvalidParameterException::class)
    override fun run(params: Parameters?): Flow<ProductModel> =
        if (params != null) {
            try {
                repository.getProduct(params.id).flowOn(context = IO)

            } catch (exception: Throwable) {
                throw exception
            }
        } else throw InvalidParameterException("Expected non-null parameter")

    class Parameters private constructor(
        val id: Int
    ) {

        companion object {

            fun forGetProduct(
                id: Int
            ) =
                Parameters(id)
        }
    }
}
