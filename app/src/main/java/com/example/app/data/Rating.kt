package com.example.app.data

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val count: Int,
    val rate: Double
)

fun RatingDto.toRatingDto(): Rating {
    return Rating(
        count = count ?: 0,
        rate = rate ?: 0.0
    )
}