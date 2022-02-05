package com.agentrediska.hardwarestore.domain.usecase.precategorysqlite

import com.agentrediska.hardwarestore.domain.model.PreCategory
import com.agentrediska.hardwarestore.domain.repository.IPreCategoryRepositorySQLite

class GetAllPreCategorySQLiteUseCase( private val iPreRepositorySQLite: IPreCategoryRepositorySQLite) {

   suspend fun getAllPreCategoryByCategoryId( categoryId: Int) : List<PreCategory> {
        return iPreRepositorySQLite.getAllPreCategoryByCategoryId( categoryId)
    }

}