package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.di.categorymodule.AppCategoryModule
import com.agentrediska.hardwarestore.di.categorymodule.DataCategoryModule
import com.agentrediska.hardwarestore.di.categorymodule.DomainCategoryModule
import com.agentrediska.hardwarestore.di.precategorymodule.AppPreCategoryModule
import com.agentrediska.hardwarestore.di.precategorymodule.DataPreCategoryModule
import com.agentrediska.hardwarestore.di.precategorymodule.DomainPreCategoryModule
import com.agentrediska.hardwarestore.presentation.categoryfragment.CategoriesFragment
import com.agentrediska.hardwarestore.presentation.precategoryfragment.PreCategoriesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [
    AppCategoryModule::class,
    DomainCategoryModule::class,
    DataCategoryModule::class,
    AppPreCategoryModule::class,
    DomainPreCategoryModule::class,
    DataPreCategoryModule::class])
interface AppComponent {

    fun inject( categoriesFragment: CategoriesFragment)

    fun inject( preCategoriesFragment: PreCategoriesFragment)
}