package com.agentrediska.hardwarestore.domain.usecase.categorysqlite

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite

class SetCategorySQLiteUseCase( private val iCategoryRepositorySQLite: ICategoryRepositorySQLite) {

   suspend fun setCategory( category: Category) : Boolean{
        return if(category.id == 0 || category.name.isEmpty()){
            false
        }else{
            iCategoryRepositorySQLite.setCategory(category = category)
            true
        }

    }
}