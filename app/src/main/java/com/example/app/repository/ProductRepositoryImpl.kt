package com.example.app.repository

import com.example.app.data.ProductItem
import com.example.app.data.toProductItem
import com.example.app.network.AiApiService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: AiApiService
) : ProductRepository {

    override suspend fun getProducts(): List<ProductItem> {
        return apiService.getProducts().map { it.toProductItem() }
    }
    override suspend fun getProductDetail(id: Int): ProductItem {
        return apiService.getProductDetail(id).toProductItem()
    }
}
