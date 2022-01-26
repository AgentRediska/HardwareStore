package com.agentrediska.hardwarestore.di

import com.agentrediska.hardwarestore.presentation.categoryfragment.CategoriesFragment
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component( modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject( categoriesFragment: CategoriesFragment)
}