package com.example.basedemoes.feature

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.example.basedemoes.R
import com.example.basedemoes.Utils
import com.example.basedemoes.adapter.MultiDeviceAdapter
import com.example.basedemoes.anim.SingleAnimator
import com.example.basedemoes.databinding.LayoutMultiDeviceBinding
import com.example.basedemoes.decoration.LinearBottomItemDecoration
import com.example.basedemoes.entity.MultiDeviceEntity
import com.example.basedemoes.widget.HideAnim
import kotlinx.android.synthetic.main.item_bulb.view.*
import kotlinx.android.synthetic.main.item_color_light.view.*
import kotlinx.android.synthetic.main.item_temperature_light.view.*
import kotlin.properties.Delegates

class MultiDeviceActivity: AppCompatActivity(), OnItemChildClickListener{
    private val TAG = "MultiDeviceActivity"
    var deviceList: ArrayList<MultiDeviceEntity> = arrayListOf()
    lateinit var multiDeviceAdapter: MultiDeviceAdapter
    var height by Delegates.notNull<Int>()
    lateinit var hideContentView: View
    val binding by lazy {
        LayoutMultiDeviceBinding.inflate(layoutInflater)
    }
        var statusTemperature0: Boolean = false
        var statusTemperature1: Boolean = false
        var statusTemperature2: Boolean = false
        var statusColor0: Boolean = false
        var statusColor1: Boolean = false
        var statusColor2: Boolean = false
        var isAnim = true

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
            initData()
            initView()
        }

        fun initData(){
            for (i in 1..3){
                deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_SWITCH, 1, true))
                deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_BULB, 1, true))
                deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_CURTAIN, 1, true))
                deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_AIR_CONDITION, 1, true))
                deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_TEMPERATURE_LIGHT, 1, true))
                deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_COLOR_LIGHT, 1, true))
            }
        }

        fun initView(){
            val multiDeviceAdapter: MultiDeviceAdapter = MultiDeviceAdapter(deviceList)
            multiDeviceAdapter.setOnItemChildClickListener(this)
            binding.multiDeviceRv.adapter = multiDeviceAdapter
            binding.multiDeviceRv.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
            binding.multiDeviceRv.addItemDecoration(LinearBottomItemDecoration(resources.getDimensionPixelOffset(
                R.dimen.dp_24)))
        }

        /**
         * 子项点击事件回调方法
         * @param view     The view whihin the ItemView that was clicked
         * @param position The position of the view int the adapter
         */
        override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
            val animator=SingleAnimator.getInstance(binding.multiDeviceRv.iv_bulb)
            val animator1=SingleAnimator.getInstance(binding.multiDeviceRv.iv_bulb)
            Log.i(TAG, ""+(animator==animator1))

            when(view.id){
                R.id.temperature_light_switch_button -> {
                    val switchButton = binding.multiDeviceRv.temperature_light_switch_button
                    switchButton.isEnabled
                    switchButton.setClickChangeState(true)
                    //height = binding.multiDeviceRv.content_temperature_light.height
                    height = 1000
                    hideContentView = binding.multiDeviceRv.content_temperature_light
                    if (switchButton.isOn) {
                        switchButton.setIsOn(false)
                        Utils.closeAnimate(hideContentView)
                    } else {
                        switchButton.setIsOn(true)
                        Utils.openAnim(hideContentView, height)
                    }
                    val view = binding.multiDeviceRv.content_temperature_light
                }
                R.id.temperature_bar -> {

                }
                R.id.temperature_light_index0 -> {
                    statusTemperature0 = updateLightStatus(statusTemperature0,
                        R.id.temperature_light_bg0)
                }
                R.id.temperature_light_index1 -> {
                    statusTemperature1 = updateLightStatus(statusTemperature1,
                        R.id.temperature_light_bg1)
                }
                R.id.temperature_light_index2 -> {
                    statusTemperature2 = updateLightStatus(statusTemperature2,
                        R.id.temperature_light_bg2)
                }

                R.id.color_light_switch_button -> {
                    val switchButton = binding.multiDeviceRv.color_light_switch_button
                    val height = binding.multiDeviceRv.content_color_light.height
                    switchButton.setClickChangeState(true)
                    if (switchButton.isOn) {
                        switchButton.setIsOn(false)
                        Utils.closeAnimate(binding.multiDeviceRv.content_color_light)
                    } else {
                        switchButton.setIsOn(true)
                        Utils.openAnim(binding.multiDeviceRv.content_color_light, height)
                    }
                }
                R.id.color_light_index0 -> {
                    statusColor0 = updateLightStatus(statusColor0, R.id.color_light_bg0)
                }
                R.id.color_light_index1 -> {
                    statusColor1 = updateLightStatus(statusColor1, R.id.color_light_bg1)
                }
                R.id.color_light_index2 -> {
                    statusColor2 = updateLightStatus(statusColor2, R.id.color_light_bg2)
                }
                R.id.bulb_name ->{
                    if (isAnim) {
                        if (!animator.isStarted || animator.isPaused) {
                            animator.start()
                        }
                    } else {
                        if (animator.isStarted && animator.isRunning) {
                            animator.pause()
                        }
                    }
                    isAnim = !isAnim
                }
            }
        }

        private fun updateLightStatus(status: Boolean, ResId: Int): Boolean{
            var view = findViewById<View>(ResId)
            if (status){
                view.visibility = GONE
            }else {
                view.visibility = VISIBLE
            }
            return !status
        }
    }
