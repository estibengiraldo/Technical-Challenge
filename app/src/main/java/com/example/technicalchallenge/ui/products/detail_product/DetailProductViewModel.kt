package com.example.technicalchallenge.ui.products.detail_product

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicalchallenge.domain.usecase.product.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase
): ViewModel() {

    private val _uiState =
        MutableStateFlow(ProductUiState(loading = true, isError = false))
    val uiState: StateFlow<ProductUiState> get() =  _uiState

    fun getProduct(id: Int){
        viewModelScope.launch {
            try {
                val product = getProductUseCase(GetProductUseCase.Parameters.forGetProduct(id)).first()
                _uiState.update { it.copy(product = product, loading = false) }
            }
            catch (exception: Exception){
                Log.d("error",exception.message.toString())
                _uiState.update { it.copy(loading = false, isError = true) }
            }
        }
    }
}