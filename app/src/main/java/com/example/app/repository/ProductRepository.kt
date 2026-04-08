package com.example.app.repository

import com.example.app.data.ProductItem

interface ProductRepository {
    suspend fun getProducts(): List<ProductItem>
    suspend fun getProductDetail(id: Int): ProductItem
}