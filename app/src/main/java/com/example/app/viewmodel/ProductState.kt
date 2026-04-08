package com.example.app.viewmodel

import com.example.app.data.ProductItem

data class ProductState(
    val productList: List<ProductItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedProduct: ProductItem? = null
)