package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.repository.PreCategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.storage.database.ICategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.IPreCategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseStorage
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCategoryLocaleStorage() : ICategoryLocaleDatabaseStorage {
        return LocalDatabaseStorage.get()
    }

    @Provides
    fun providePreCategoryLocaleStorage() : IPreCategoryLocaleDatabaseStorage {
        return LocalDatabaseStorage.get()
    }

    @Provides
    fun provideCategoryReposLocalDB(
        categoryLocaleDBStorage : ICategoryLocaleDatabaseStorage
    ) : CategoryRepositorySQLite {
        return CategoryRepositorySQLite(categoryLocaleDBStorage)
    }

    @Provides
    fun providePreCategoryReposLocalDB(
        categoryLocaleDBStorage : IPreCategoryLocaleDatabaseStorage
    ) : PreCategoryRepositorySQLite {
        return PreCategoryRepositorySQLite(categoryLocaleDBStorage)
    }

}