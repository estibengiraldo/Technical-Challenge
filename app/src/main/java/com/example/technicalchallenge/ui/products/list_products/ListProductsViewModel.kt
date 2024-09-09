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
        MutableStateFlow(ListProductsUiState(loading = true, listProducts = emptyList(), isError = false))
    val uiState: StateFlow<ListProductsUiState> get() =  _uiState


    val textFilter = MutableStateFlow(EMPTY)
    private val _order =
        MutableStateFlow(FIRST_TYPE)
    val order: StateFlow<Int> get() =  _order


    init {
        getProducts()
    }


    private fun getProducts(){
        viewModelScope.launch {
            try {
                val listProducts = getProductsUseCase().first()
                downloadProductsUseCase(DownloadProductsUseCase.Parameters.forDownloadProducts(listProducts))
                _uiState.update { it.copy(listProducts = listProducts, loading = false) }
            }

            catch (exception: Exception){
                Log.d("error",exception.message.toString())
                _uiState.update { it.copy(loading = false, isError = true) }
            }
        }
    }

    fun onOrderClick(){
        when(order.value){
            FIRST_TYPE -> _order.value = SECOND_TYPE
            SECOND_TYPE -> _order.value = THIRD_TYPE
            THIRD_TYPE -> _order.value = SECOND_TYPE
        }
    }

    companion object {
        const val FIRST_TYPE = 1
        const val SECOND_TYPE = 2
        const val THIRD_TYPE = 3
        const val EMPTY = ""
    }
}