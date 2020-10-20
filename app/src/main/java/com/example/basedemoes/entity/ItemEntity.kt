package com.example.basedemoes.entity

import kotlin.reflect.KClass

data class ItemEntity(
    val name: Int = 0,
    val imageSrc : Int = 0,
    val activity : KClass<*>? = null
)