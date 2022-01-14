package com.agentrediska.hardwarestore.domain.usecase

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySharedPref

class GetCategorySharedPrefUseCase(private val iCategoryRepositorySharedPref: ICategoryRepositorySharedPref) {

    fun getCategory() : Category{
       return iCategoryRepositorySharedPref.getCategory()
    }
}