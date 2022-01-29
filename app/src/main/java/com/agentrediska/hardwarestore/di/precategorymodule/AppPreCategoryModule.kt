package com.agentrediska.hardwarestore.di.precategorymodule

import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.presentation.precategoryfragment.PreCategoriesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppPreCategoryModule {

    @Provides
    fun provideViewModelFactory(
        getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase
    ) : PreCategoriesViewModelFactory{
        return PreCategoriesViewModelFactory(
            getAllPreCategorySQLiteUseCase = getAllPreCategorySQLiteUseCase
        )
    }
}