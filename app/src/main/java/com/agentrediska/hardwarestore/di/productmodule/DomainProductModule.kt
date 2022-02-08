package com.agentrediska.hardwarestore.di.productmodule

import com.agentrediska.hardwarestore.data.repository.ProductRepositorySQLite
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.GetAllProductsUseCase
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.SetProductUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainProductModule {

    @Provides
    fun provideGetAllProductUseCase(
        productRepositorySQLite: ProductRepositorySQLite
    ) : GetAllProductsUseCase{
        return GetAllProductsUseCase( productRepositorySQLite)
    }

    @Provides
    fun provideSetProductUseCase(
        productRepositorySQLite: ProductRepositorySQLite
    ) : SetProductUseCase {
        return SetProductUseCase( productRepositorySQLite)
    }
}