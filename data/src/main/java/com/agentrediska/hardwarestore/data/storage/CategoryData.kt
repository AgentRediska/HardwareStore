package com.agentrediska.hardwarestore.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryData(
    @PrimaryKey val _id: Int,
    val name: String
)