package com.agentrediska.hardwarestore.di.precategorymodule

import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.SetPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.presentation.precategoryfragment.PreCategoriesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppPreCategoryModule {

    @Provides
    fun provideViewModelFactory(
        getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase,
        setPreCategorySQLiteUseCase: SetPreCategorySQLiteUseCase
    ) : PreCategoriesViewModelFactory{
        return PreCategoriesViewModelFactory(
            getAllPreCategorySQLiteUseCase = getAllPreCategorySQLiteUseCase,
            setPreCategorySQLiteUseCase = setPreCategorySQLiteUseCase
        )
    }
}