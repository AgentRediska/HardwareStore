package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.storage.ICategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseStorage
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCategoryLocaleStorage() : LocalDatabaseStorage {
        return LocalDatabaseStorage.get()
    }

    @Provides
    fun provideCategoryReposLocalDB(
        categoryLocaleDBStorage : LocalDatabaseStorage
    ) : CategoryRepositorySQLite {
        return CategoryRepositorySQLite(categoryLocaleDBStorage)
    }

}