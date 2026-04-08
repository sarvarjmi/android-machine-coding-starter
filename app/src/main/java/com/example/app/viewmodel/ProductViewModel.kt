package com.example.app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.app.data.ProductItem
import com.example.app.usecase.ProductDetailUseCase
import com.example.app.usecase.ProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productListUseCase: ProductListUseCase,
    private val productDetailUseCase: ProductDetailUseCase
): ViewModel() {

    val _state = MutableStateFlow(ProductState())
    val state = _state.asStateFlow()

    fun processIntent(intent: ProductIntent) {
        when (intent) {
            is ProductIntent.Loading -> _state.value = _state.value.copy(isLoading = true)
            is ProductIntent.ProductList -> _state.value = _state.value.copy(productList = intent.productList, isLoading = false)
            is ProductIntent.ProductDetail -> _state.value = _state.value.copy(selectedProduct = intent.product)
        }
    }

    suspend fun getProductList(): List<ProductItem> {
        return productListUseCase()
    }

    suspend fun getProductDetail(id: Int): ProductItem {
        return productDetailUseCase(id)
    }
}