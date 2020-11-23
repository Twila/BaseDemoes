package com.example.basedemoes.adapter

import android.animation.ObjectAnimator
import android.util.Log
import android.view.KeyCharacterMap.load
import android.view.MotionEvent
import android.view.View
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.basedemoes.R
import com.example.basedemoes.Utils
import com.example.basedemoes.anim.SingleAnimator
import com.example.basedemoes.entity.MultiDeviceEntity
import com.example.basedemoes.widget.ArcSeekBar
import java.security.AccessController.getContext

class MultiDeviceAdapter(data: MutableList<MultiDeviceEntity>? = null): BaseMultiItemQuickAdapter<MultiDeviceEntity, BaseViewHolder>(
    data) {
    private val TAG = "MultiDeviceAdapter"
    
    init {
        addItemType(MultiDeviceEntity.TYPE_SWITCH, R.layout.item_switch)
        addItemType(MultiDeviceEntity.TYPE_BULB, R.layout.item_bulb)
        addItemType(MultiDeviceEntity.TYPE_CURTAIN, R.layout.item_curtain)
        addItemType(MultiDeviceEntity.TYPE_AIR_CONDITION, R.layout.item_air_condition)
        addItemType(MultiDeviceEntity.TYPE_TEMPERATURE_LIGHT, R.layout.item_temperature_light)
        addItemType(MultiDeviceEntity.TYPE_COLOR_LIGHT, R.layout.item_color_light)

        addChildClickViewIds(R.id.temperature_light_switch_button,
            R.id.temperature_light_index0,
            R.id.temperature_light_index1,
            R.id.temperature_light_index2)
        addChildClickViewIds(R.id.color_light_switch_button,
            R.id.color_light_index0,
            R.id.color_light_index1,
            R.id.color_light_index2)
        addChildClickViewIds(R.id.bulb_name)
    }


    override fun convert(holder: BaseViewHolder, item: MultiDeviceEntity) {
        var isAnim = true
        item?. apply {
            when (holder.itemViewType){
                // TODO: 2020/11/20 test animation
                MultiDeviceEntity.TYPE_BULB -> {

                }
                MultiDeviceEntity.TYPE_TEMPERATURE_LIGHT -> {
                    val arcSeekBar = holder.getView<ArcSeekBar>(R.id.temperature_bar)
                    arcSeekBar.isEnabled

                    arcSeekBar.setOnTouchListener { v, event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                                var thumbCenterX = arcSeekBar.thumbCenterX
                                var thumbCenterY = arcSeekBar.thumbCenterY
                                var thumbRadius = arcSeekBar.thumbRadius
                                var pressDis = Utils.getDistance(thumbCenterX,
                                    thumbCenterY,
                                    event.getX(),
                                    event.getY())
                                Log.d(TAG, "圆心： " + thumbCenterX + "," + thumbCenterY)
                                Log.d(TAG, "手指定位： " + event.getX() + "," + event.getY())
                                if (Math.abs(pressDis - thumbRadius) < 200) {
                                    v.parent.requestDisallowInterceptTouchEvent(true)
                                }
                            }
                            MotionEvent.ACTION_UP -> v.parent.requestDisallowInterceptTouchEvent(
                                false)
                        }
                        false
                    }
                }
            }
        }
    }


}