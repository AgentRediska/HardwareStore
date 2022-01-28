package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.GetAllCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.SetCategorySQLiteUseCase
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