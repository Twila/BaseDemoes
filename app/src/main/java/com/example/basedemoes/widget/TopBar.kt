package com.example.basedemoes.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.basedemoes.R
import java.util.jar.Attributes

open class TopBar(context: Context, attrs: AttributeSet?): Toolbar(context, attrs){

    init {
        initView()
    }

    public interface OnTopBarEventListener{
        /**
         * 自定义顶部导航栏左侧item点击事件
         */
        fun onTopBarLeftClick(leftItemView: View, context: Context){
        }

        /**
         * 自定义顶部导航栏右侧item点击事件
         */
        fun onTopBarRightClick(rightItemView: View, context: Context)

    }

    constructor(context: Context): this(context, null)

    private fun initView(){
        LayoutInflater.from(context).inflate(R.layout.top_bar, this)
    }



}