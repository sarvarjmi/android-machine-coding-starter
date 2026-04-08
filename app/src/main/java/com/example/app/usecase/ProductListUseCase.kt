package com.example.app.usecase

import com.example.app.data.ProductItem
import com.example.app.repository.ProductRepository
import javax.inject.Inject

class ProductListUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): List<ProductItem> {
        return productRepository.getProducts()
    }
}