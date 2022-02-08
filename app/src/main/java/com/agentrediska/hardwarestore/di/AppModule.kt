package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.GetAllCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.SetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.SetPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.GetAllProductsUseCase
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.SetProductUseCase
import com.agentrediska.hardwarestore.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideViewModelFactory(
        setCategorySQLiteUseCase: SetCategorySQLiteUseCase,
        getCategorySQLiteUseCase: GetCategorySQLiteUseCase,
        getAllCategorySQLiteUseCase: GetAllCategorySQLiteUseCase,
        getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase,
        setPreCategorySQLiteUseCase: SetPreCategorySQLiteUseCase,
        getAllProductsUseCase: GetAllProductsUseCase,
        setProductUseCase: SetProductUseCase
    ) : ViewModelFactory {
        return ViewModelFactory(
            setCategorySQLiteUseCase,
            getCategorySQLiteUseCase,
            getAllCategorySQLiteUseCase,
            getAllPreCategorySQLiteUseCase,
            setPreCategorySQLiteUseCase,
            getAllProductsUseCase,
            setProductUseCase
        )
    }
}