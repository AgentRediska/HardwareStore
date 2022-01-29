package com.agentrediska.hardwarestore.di.precategorymodule

import com.agentrediska.hardwarestore.data.repository.PreCategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.storage.database.IPreCategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseStorage
import dagger.Module
import dagger.Provides

@Module
class DataPreCategoryModule {

    @Provides
    fun providePreCategoryLocaleStorage() : IPreCategoryLocaleDatabaseStorage {
        return LocalDatabaseStorage.get()
    }

    @Provides
    fun providePreCategoryRepositorySQLite(
        preCategoryStorage: IPreCategoryLocaleDatabaseStorage
    ) : PreCategoryRepositorySQLite {
        return PreCategoryRepositorySQLite( categoryStorage = preCategoryStorage)
    }
}