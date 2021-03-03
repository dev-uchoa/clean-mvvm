package com.debug.data

import com.debug.data.api.MealApi
import com.debug.data.model.toCategory
import com.debug.domain.model.Category
import com.debug.network.Output
import com.debug.network.parseResponse

class MealRepositoryImpl(
    private val service: MealApi
) : MealRepository {

    override suspend fun getCategories(): List<Category> {
        val result = service.getCategories().parseResponse()

        return when (result) {
            is Output.Success -> {
                val categoryResponseList = result.value.categories

                categoryResponseList.map {
                    it.toCategory()
                }
            }
            is Output.Failure -> throw GetCategoriesException()
        }
    }
}

interface MealRepository {
    suspend fun getCategories(): List<Category>
}

class GetCategoriesException : Exception()
