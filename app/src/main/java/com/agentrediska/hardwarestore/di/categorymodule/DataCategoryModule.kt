package com.agentrediska.hardwarestore.di.categorymodule

import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.repository.PreCategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.storage.database.ICategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.IPreCategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseStorage
import dagger.Module
import dagger.Provides

@Module
class DataCategoryModule {

    @Provides
    fun provideCategoryLocaleStorage() : ICategoryLocaleDatabaseStorage {
        return LocalDatabaseStorage.get()
    }

    @Provides
    fun provideCategoryReposLocalDB(
        categoryLocaleDBStorage : ICategoryLocaleDatabaseStorage
    ) : CategoryRepositorySQLite {
        return CategoryRepositorySQLite(categoryLocaleDBStorage)
    }

}