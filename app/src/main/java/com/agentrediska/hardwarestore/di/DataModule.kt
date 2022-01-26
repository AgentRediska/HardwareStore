package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.storage.ICategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseRepository
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCategoryLocaleStorage() : ICategoryLocaleDatabaseStorage {
        return LocalDatabaseRepository.get()
    }

    @Provides
    fun provideCategoryReposLocalDB(
        categoryLocaleDBStorage : ICategoryLocaleDatabaseStorage
    ) : ICategoryRepositorySQLite {
        return CategoryRepositorySQLite(categoryLocaleDBStorage)
    }

}