package com.agentrediska.hardwarestore.domain.repository

import com.agentrediska.hardwarestore.domain.model.Category

interface ICategoryRepositorySQLite {

    fun getCategory(): Category

    fun getCategoryById( id: Int): Category

    fun setCategory( category: Category)

}