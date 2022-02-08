package com.agentrediska.hardwarestore.di.productmodule

import com.agentrediska.hardwarestore.data.repository.ProductRepositorySQLite
import com.agentrediska.hardwarestore.data.storage.database.IProductLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseStorage
import dagger.Module
import dagger.Provides

@Module
class DataProductModule {

    @Provides
    fun provideProductLocaleStorage() : IProductLocaleDatabaseStorage {
        return LocalDatabaseStorage.get()
    }

    @Provides
    fun provideProductRepositorySQLite(
        productLocaleStorage: IProductLocaleDatabaseStorage
    ) : ProductRepositorySQLite {
        return ProductRepositorySQLite( productLocaleStorage)
    }
}