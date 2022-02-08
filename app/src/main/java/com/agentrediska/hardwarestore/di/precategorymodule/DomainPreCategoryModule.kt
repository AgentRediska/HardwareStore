package com.agentrediska.hardwarestore.di.precategorymodule

import com.agentrediska.hardwarestore.data.repository.PreCategoryRepositorySQLite
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.SetPreCategorySQLiteUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainPreCategoryModule {

    @Provides
    fun provideGetAllPreCategorySQLiteUseCase(
        preRepositorySQLite: PreCategoryRepositorySQLite
    ) : GetAllPreCategorySQLiteUseCase {
        return GetAllPreCategorySQLiteUseCase( preRepositorySQLite)
    }

    @Provides
    fun provideSetPreCategorySQLiteUseCase(
        preCategoryRepositorySQLite: PreCategoryRepositorySQLite
    ) : SetPreCategorySQLiteUseCase {
        return SetPreCategorySQLiteUseCase( preCategoryRepositorySQLite)
    }

}