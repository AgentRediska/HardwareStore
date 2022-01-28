package com.agentrediska.hardwarestore.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PreCategoryData (
    @PrimaryKey
    val _id: Int,
    val _id_category: Int,
    val name: String
)