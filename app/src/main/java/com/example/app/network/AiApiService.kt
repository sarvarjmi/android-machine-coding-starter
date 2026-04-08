package com.example.app.network

import com.example.app.data.ProductItemDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AiApiService {

    @GET("/products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 10
    ): List<ProductItemDto>

    @GET("/products/{id}")
    suspend fun getProductDetail(
        @Path("id") id: Int
    ): ProductItemDto
}
