package com.example.app.data

import kotlinx.serialization.Serializable

@Serializable
data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val ratingDto: Rating,
    val title: String
)