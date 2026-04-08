package com.example.app.usecase

import com.example.app.data.ProductItem
import com.example.app.repository.ProductRepository
import javax.inject.Inject

class ProductDetailUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(id: Int): ProductItem {
        return productRepository.getProductDetail(id)
    }
}