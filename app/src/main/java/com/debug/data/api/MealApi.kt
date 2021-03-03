package com.debug.data.api

import com.debug.data.model.CategoryResponse
import com.debug.network.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    @GET("categories.php")
    suspend fun getCategories(): Response<BaseResponse<CategoryResponse>>
}