package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySQLite
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
        categoryRepository: CategoryRepositorySQLite
    ) : GetCategorySQLiteUseCase {
        return GetCategorySQLiteUseCase( iCategoryRepositorySQLite = categoryRepository)
    }

    @Provides
    fun provideGetAllCategorySQLiteUseCase(
        categoryRepository: CategoryRepositorySQLite
    ) : GetAllCategorySQLiteUseCase {
        return GetAllCategorySQLiteUseCase( iCategoryRepositorySQLite = categoryRepository)
    }

    @Provides
    fun provideSetAllCategorySQLiteUseCase(
        categoryRepository: CategoryRepositorySQLite
    ) : SetCategorySQLiteUseCase {
        return SetCategorySQLiteUseCase( iCategoryRepositorySQLite = categoryRepository)
    }

}