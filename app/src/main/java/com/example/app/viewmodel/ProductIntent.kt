package com.example.app.viewmodel

import com.example.app.data.ProductItem

sealed class ProductIntent {
    object Loading : ProductIntent()
    data class ProductList(val productList: List<ProductItem>) : ProductIntent()
    data class ProductDetail(val product: ProductItem) : ProductIntent()
}