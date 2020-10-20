package com.example.basedemoes.widget

import android.content.Context
import android.view.View
import java.util.jar.Attributes

open class TopBar(val context: Context, val attrs: Attributes?){
    init {
        initContent(context)
        initAttrs(context, attrs)
        initView()
    }

    public interface OnTopBarEventListener{
        /**
         * 自定义顶部导航栏左侧item点击事件
         */
        fun onTopBarLeftClick(leftItemView: View)

        /**
         * 自定义顶部导航栏右侧item点击事件
         */
        fun onTopBarRightClick(rightItemView: View)

    }

    constructor(context: Context): this(context, null)

    private fun initContent(context: Context){

    }

    private fun initAttrs(context: Context, attrs: Attributes?){

    }

    private fun initView(){

    }


}