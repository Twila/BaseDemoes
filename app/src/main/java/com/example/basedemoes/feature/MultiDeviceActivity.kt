package com.example.basedemoes.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.example.basedemoes.R
import com.example.basedemoes.adapter.MultiDeviceAdapter
import com.example.basedemoes.databinding.LayoutMultiDeviceBinding
import com.example.basedemoes.decoration.LinearBottomItemDecoration
import com.example.basedemoes.entity.MultiDeviceEntity

class MultiDeviceActivity: AppCompatActivity() {
    var deviceList: ArrayList<MultiDeviceEntity> = arrayListOf()
    lateinit var multiDeviceAdapter: MultiDeviceAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutMultiDeviceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        val multiDeviceAdapter: MultiDeviceAdapter = MultiDeviceAdapter(deviceList)
        binding.multiDeviceRv.adapter = multiDeviceAdapter
        binding.multiDeviceRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.multiDeviceRv.addItemDecoration(LinearBottomItemDecoration(resources.getDimensionPixelOffset(R.dimen.dp_24)))
        initView()
    }

    fun initData(){
        for (i in 1..3){
            deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_SWITCH, 1, true))
            deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_BULB, 1, true))
            deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_CURTAIN, 1, true))
            deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_AIR_CONDITION, 1, true))
            deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_TEMPERATURE_LIGHT, 1, true))
            deviceList.add(MultiDeviceEntity(MultiDeviceEntity.TYPE_COLOR_LIGHT,1, true))
        }
    }
    fun initView(){
        // TODO: 2020/11/12 子项点击事件
//        multiDeviceAdapter.setOnItemChildClickListener(OnItemChildClickListener())
    }
}