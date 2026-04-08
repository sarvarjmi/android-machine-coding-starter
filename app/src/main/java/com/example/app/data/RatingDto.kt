package com.example.app.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingDto(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("rate")
    val rate: Double? = null
)