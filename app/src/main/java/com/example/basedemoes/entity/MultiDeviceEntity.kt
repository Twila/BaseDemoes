package com.example.basedemoes.entity

import com.chad.library.adapter.base.entity.MultiItemEntity

class MultiDeviceEntity(override var itemType: Int, val onLine: Int, val status:Boolean, var content: String?): MultiItemEntity{

    constructor(itemType: Int, onLine: Int, status: Boolean): this(itemType, onLine, status, null)
    constructor(itemType: Int): this(itemType, 0, false, null)

    companion object {
        const val TYPE_SWITCH: Int = 1
        const val TYPE_BULB: Int = 2
        const val TYPE_CURTAIN: Int = 3
        const val TYPE_AIR_CONDITION: Int = 4
        const val TYPE_TEMPERATURE_LIGHT: Int = 5
        const val TYPE_COLOR_LIGHT: Int = 6
    }
}