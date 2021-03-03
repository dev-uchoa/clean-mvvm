package com.debug

import com.debug.data.MealRepository
import com.debug.data.MealRepositoryImpl
import com.debug.data.api.MealApi
import com.debug.domain.GetCategories
import com.debug.domain.GetCategoriesUseCase
import com.debug.network.Service
import com.debug.presenter.MealViewModel
import org.koin.dsl.module

val mealServiceModule = module {

    single { Service().createService(MealApi::class.java) }

    single<MealRepository> { MealRepositoryImpl(get()) }

    single<GetCategoriesUseCase> { GetCategories(get()) }

    single { MealViewModel(get()) }
}