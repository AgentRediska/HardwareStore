package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.di.categorymodule.DataCategoryModule
import com.agentrediska.hardwarestore.di.categorymodule.DomainCategoryModule
import com.agentrediska.hardwarestore.di.precategorymodule.DataPreCategoryModule
import com.agentrediska.hardwarestore.di.precategorymodule.DomainPreCategoryModule
import com.agentrediska.hardwarestore.di.productmodule.DataProductModule
import com.agentrediska.hardwarestore.di.productmodule.DomainProductModule
import com.agentrediska.hardwarestore.presentation.ViewModelFactory
import com.agentrediska.hardwarestore.presentation.categoryfragment.CategoriesFragment
import com.agentrediska.hardwarestore.presentation.precategoryfragment.PreCategoriesFragment
import com.agentrediska.hardwarestore.presentation.productfragment.ProductsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [
    DomainCategoryModule::class, DataCategoryModule::class,
    DomainPreCategoryModule::class, DataPreCategoryModule::class,
    DomainProductModule::class, DataProductModule::class])
interface AppComponent {

    fun inject( categoriesFragment: CategoriesFragment)

    fun inject( preCategoriesFragment: PreCategoriesFragment)

    fun inject( productsFragment: ProductsFragment)

    fun inject( vmFactory: ViewModelFactory)
}