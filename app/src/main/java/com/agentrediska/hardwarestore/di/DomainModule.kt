package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite
import com.agentrediska.hardwarestore.domain.usecase.GetAllCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySQLiteUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetCategorySQLiteUseCase(
        categoryRepository: ICategoryRepositorySQLite
    ) : GetCategorySQLiteUseCase {
        return GetCategorySQLiteUseCase( iCategoryRepositorySQLite = categoryRepository)
    }

    @Provides
    fun provideGetAllCategorySQLiteUseCase(
        categoryRepository: ICategoryRepositorySQLite
    ) : GetAllCategorySQLiteUseCase {
        return GetAllCategorySQLiteUseCase( iCategoryRepositorySQLite = categoryRepository)
    }

    @Provides
    fun provideSetAllCategorySQLiteUseCase(
        categoryRepository: ICategoryRepositorySQLite
    ) : SetCategorySQLiteUseCase {
        return SetCategorySQLiteUseCase( iCategoryRepositorySQLite = categoryRepository)
    }

}