package com.agentrediska.hardwarestore.domain.repository

import com.agentrediska.hardwarestore.domain.model.PreCategory

interface IPreCategoryRepositorySQLite {

    suspend fun getPreCategory(): PreCategory

    suspend fun getPreCategoryById( id: Int): PreCategory

    suspend fun setPreCategory( preCategory: PreCategory)

    suspend fun getAllPreCategoryByCategoryId( categoryId: Int) : List<PreCategory>
}