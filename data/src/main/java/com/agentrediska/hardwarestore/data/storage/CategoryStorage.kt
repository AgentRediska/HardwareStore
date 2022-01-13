package com.agentrediska.hardwarestore.data.storage

import com.agentrediska.hardwarestore.domain.model.Category

interface CategoryStorage {

    fun save(category: CategoryInStorage)

    fun get() : CategoryInStorage
}