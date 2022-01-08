package com.agentrediska.hardwarestore.domain.model

data class Category(
    val nameOfCategory: String,
    val listOfPreCategory: List<PreCategory>
    )