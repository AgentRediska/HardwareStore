package com.agentrediska.hardwarestore.data.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductData(
    @PrimaryKey val _id: Int,
    val _id_pre_category: Int,
    var name: String,
    val vendor_code: String,
    var price: Int,
    val type_count: String
)
