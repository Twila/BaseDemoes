package com.example.basedemoes.entity

import com.chad.library.adapter.base.entity.MultiItemEntity

class MultiDeviceEntity(override val itemType: Int, spanSize: Int, content: String?): MultiItemEntity{

    val TYPE_SWITCH = 1
    val TYPE_CURTAIN = 2
    val TYPE_AIR_CONDITION = 3
    val TYPE_LIGHT = 4
    val TYPE_PANEL = 5

    constructor(itemType: Int, spanSize: Int): this(itemType, spanSize, null)






}