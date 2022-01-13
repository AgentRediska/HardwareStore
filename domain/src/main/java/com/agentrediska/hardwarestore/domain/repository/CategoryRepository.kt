package com.agentrediska.hardwarestore.domain.repository

import com.agentrediska.hardwarestore.domain.model.Category

interface CategoryRepository {

    fun getCategory(): Category

    fun testSetCategory( category: Category)
}