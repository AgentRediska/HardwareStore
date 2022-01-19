package com.agentrediska.hardwarestore.domain.repository

import com.agentrediska.hardwarestore.domain.model.Category

interface ICategoryRepositorySQLite {

    suspend fun getCategory(): Category

    suspend fun getCategoryById( id: Int): Category

    suspend fun setCategory( category: Category)

}