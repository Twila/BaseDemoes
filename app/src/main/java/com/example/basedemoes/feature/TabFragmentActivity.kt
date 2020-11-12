package com.example.basedemoes.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.basedemoes.R
import com.example.basedemoes.base.BaseActivity
import com.example.basedemoes.databinding.LayoutTabFragmentBinding
import com.example.basedemoes.feature.ui.SimpleImageFragment
import com.example.basedemoes.entity.TabEntity
import com.example.basedemoes.view_model.TabFragmentViewModel
import com.flyco.tablayout.listener.CustomTabEntity

class TabFragmentActivity: BaseActivity<TabFragmentViewModel>() {
    val mFragments = ArrayList<Fragment>()
    val solidTabEntities = ArrayList<CustomTabEntity>()
    val imgSrc = arrayOf(R.mipmap.yibo5, R.mipmap.yibo9, R.mipmap.yibo10, R.mipmap.yibo15)
    val solidTitles = arrayOf("首页","资源","消息","设置")
    val iconUnselected = intArrayOf(R.drawable.ic_home, R.drawable.ic_resource,
        R.drawable.ic_chat, R.drawable.ic_more)
    val iconSeleted = intArrayOf(R.drawable.ic_home_selected, R.drawable.ic_resource_selected,
        R.drawable.ic_chat_selected, R.drawable.ic_more_selected)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutTabFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTopTitle(getString(R.string.tab_fragment_demo))
        initFragments()
        initSolidTab()

        binding.solidTab.setTabData(solidTabEntities, this, R.id.frame_layout, mFragments)
        //初始Tab显示
        binding.solidTab.setCurrentTab(1)
        //显示未读
        binding.solidTab.showDot(0)
        binding.solidTab.showMsg(1, 200)
        binding.solidTab.setMsgMargin(1, -5F, 5F)
    }


    fun initFragments(){
        for (i in imgSrc.indices){
            mFragments.add(SimpleImageFragment(imgSrc[i]))
        }
    }

    fun initSolidTab(){
        for (i in solidTitles.indices){
            solidTabEntities.add(TabEntity(solidTitles[i], iconSeleted[i], iconUnselected[i]))
        }
    }
}