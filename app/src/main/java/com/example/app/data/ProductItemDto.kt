package com.example.app.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductItemDto(
    @SerialName("category")
    val category: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("price")
    val price: Double? = null,
    @SerialName("rating")
    val ratingDto: RatingDto? = null,
    @SerialName("title")
    val title: String? = null
)


fun ProductItemDto.toProductItem(): ProductItem {
    return ProductItem(
        category = category ?: "",
        description = description ?: "",
        id = id ?: 0,
        image = image ?: "",
        price = price ?: 0.0,
        ratingDto = ratingDto?.toRatingDto() ?: Rating(0, 0.0),
        title = title ?: ""
    )
}