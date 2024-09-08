package com.example.technicalchallenge.domain.usecase.product

import com.example.technicalchallenge.core.usecase.UseCaseSuspend
import com.example.technicalchallenge.domain.model.product.ProductModel
import com.example.technicalchallenge.domain.repository.product.ProductRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.security.InvalidParameterException
import javax.inject.Inject

class DownloadProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) : UseCaseSuspend<Unit, DownloadProductsUseCase.Parameters>() {

    @Throws(InvalidParameterException::class)
    override suspend fun run(params: Parameters?): Unit = withContext(IO) {
        if (params != null) {
            try {
                productRepository.insertProducts(params.products)

            } catch (exception: Throwable) {
                throw exception

            }
        } else throw InvalidParameterException("Expected non-null parameter")
    }

    class Parameters private constructor(
        val products: List<ProductModel>
    ) {

        companion object {

            fun forDownloadProducts(
                products: List<ProductModel>
            ) =
                Parameters(products)
        }
    }
}
