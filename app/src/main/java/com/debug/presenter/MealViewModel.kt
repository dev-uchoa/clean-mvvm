package com.debug.presenter

import androidx.lifecycle.*
import com.debug.domain.GetCategoriesUseCase
import com.debug.domain.model.Category
import com.debug.presenter.model.CategoryUiModel
import com.debug.presenter.model.toUiModel
import kotlinx.coroutines.launch

class MealViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryUiModel>>()
    val categories = _categories as LiveData<List<CategoryUiModel>>

    fun getCategories() {
        viewModelScope.launch {
            val categoryList = getCategoriesUseCase()

            _categories.value = categoryList.map { category ->
                category.toUiModel()
            }
        }
    }
}

