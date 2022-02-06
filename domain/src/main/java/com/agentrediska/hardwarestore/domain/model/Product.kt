package com.agentrediska.hardwarestore.domain.model

data class Product(
    val id: Int,
    val preCategoryId: Int,
    var name: String,
    val vendorCode: String,
    var price: Int,
    val typeCount: String
    )
