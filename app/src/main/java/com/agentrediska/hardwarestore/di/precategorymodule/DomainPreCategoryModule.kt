package com.agentrediska.hardwarestore.di.precategorymodule

import com.agentrediska.hardwarestore.data.repository.PreCategoryRepositorySQLite
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainPreCategoryModule {

    @Provides
    fun provideGetAllPreCategorySQLiteUseCase(
        preRepositorySQLite: PreCategoryRepositorySQLite
    ) : GetAllPreCategorySQLiteUseCase {
        return GetAllPreCategorySQLiteUseCase(iPreRepositorySQLite = preRepositorySQLite)
    }

}