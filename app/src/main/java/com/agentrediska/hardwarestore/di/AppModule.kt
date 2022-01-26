package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.domain.usecase.GetAllCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.presentation.categoryfragment.CategoriesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideViewModelFactory(setCategorySQLiteUseCase: SetCategorySQLiteUseCase,
                                getCategorySQLiteUseCase: GetCategorySQLiteUseCase,
                                getAllCategorySQLiteUseCase: GetAllCategorySQLiteUseCase
    ) : CategoriesViewModelFactory {
        return CategoriesViewModelFactory(
            setCategorySQLiteUseCase = setCategorySQLiteUseCase,
            getCategorySQLiteUseCase = getCategorySQLiteUseCase,
            getAllCategorySQLiteUseCase = getAllCategorySQLiteUseCase)
    }

}