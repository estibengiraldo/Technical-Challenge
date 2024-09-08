package com.example.technicalchallenge.ui.products.list_products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicalchallenge.domain.usecase.product.DownloadProductsUseCase
import com.example.technicalchallenge.domain.usecase.product.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val downloadProductsUseCase: DownloadProductsUseCase
): ViewModel() {

    private val _uiState =
        MutableStateFlow(ProductUiState(loading = false, listProducts = emptyList(), isSuccess = false, isError = false))
    val uiState: StateFlow<ProductUiState> get() =  _uiState


    val textFilter = MutableStateFlow("")
    private val _order =
        MutableStateFlow(0)
    val order: StateFlow<Int> get() =  _order


    init {
        getProducts()
    }


    private fun getProducts(){
        viewModelScope.launch {
            try {
                val listProducts = getProductsUseCase().first()
                downloadProductsUseCase(DownloadProductsUseCase.Parameters.forDownloadProducts(listProducts))
                _uiState.update { it.copy(listProducts = listProducts) }
                Log.d("LISTA", listProducts.toString())
            }

            catch (exception: Exception){
                Log.d("error",exception.message.toString())
                _uiState.update { it.copy(isError = true) }
            }
        }
    }

    fun onOrderClick(){
        when(order.value){
            0 -> _order.value = 1
            1 -> _order.value = 2
            2 -> _order.value = 1
        }
    }
}