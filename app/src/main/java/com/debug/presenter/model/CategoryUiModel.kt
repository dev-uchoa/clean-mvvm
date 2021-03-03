package com.debug.presenter.model

import com.debug.domain.model.Category

class CategoryUiModel(
    val name: String,
    val thumb: String
)

fun Category.toUiModel() = CategoryUiModel(
    name = this.name,
    thumb = this.thumb
)

