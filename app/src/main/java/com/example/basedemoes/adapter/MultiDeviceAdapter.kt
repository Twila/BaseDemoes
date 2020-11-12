package com.example.basedemoes.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.basedemoes.R
import com.example.basedemoes.entity.MultiDeviceEntity
import com.example.basedemoes.widget.SwitchButton

class MultiDeviceAdapter(data: MutableList<MultiDeviceEntity> ?= null): BaseMultiItemQuickAdapter<MultiDeviceEntity, BaseViewHolder>(data) {
    init {
        addItemType(MultiDeviceEntity.TYPE_SWITCH, R.layout.item_switch)
        addItemType(MultiDeviceEntity.TYPE_BULB, R.layout.item_bulb)
        addItemType(MultiDeviceEntity.TYPE_CURTAIN, R.layout.item_curtain)
        addItemType(MultiDeviceEntity.TYPE_AIR_CONDITION, R.layout.item_air_condition)
        addItemType(MultiDeviceEntity.TYPE_TEMPERATURE_LIGHT, R.layout.item_temperature_light)
        addItemType(MultiDeviceEntity.TYPE_COLOR_LIGHT, R.layout.item_color_light)

        addChildClickViewIds(R.id.temperature_light_switch_button, R.id.temperature_light_index0, R.id.temperature_light_index1, R.id.temperature_light_index2)
        addChildClickViewIds(R.id.color_light_switch_button, R.id.color_light_index0, R.id.color_light_index1, R.id.color_light_index2)
    }

    override fun convert(holder: BaseViewHolder, item: MultiDeviceEntity) {
        item?. apply {
            when (holder.itemViewType){
                MultiDeviceEntity.TYPE_TEMPERATURE_LIGHT -> {
                    val switchButton = holder.getView<SwitchButton>(R.id.temperature_light_switch_button)
                    val light_index0 = holder.getView<ImageView>(R.id.temperature_light_index0)
                    val light_index1 = holder.getView<ImageView>(R.id.temperature_light_index1)
                    val light_index2 = holder.getView<ImageView>(R.id.temperature_light_index2)

                    // TODO: 2020/11/12 离在线状态
                    if (item.onLine == 1 && item.status) {



                    }else {

                    }
                }
            }
        }


    }
}