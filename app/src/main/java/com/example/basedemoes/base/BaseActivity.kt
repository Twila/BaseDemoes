package com.example.basedemoes.base

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.View.inflate
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
import android.view.WindowManager.LayoutParams.MATCH_PARENT
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.basedemoes.R
import com.example.basedemoes.widget.TopBar
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.top_bar.*

abstract class BaseActivity<VM: BaseViewModel>: AppCompatActivity(), TopBar.OnTopBarEventListener{
    val TAG = this.javaClass.simpleName
    lateinit var  title: TextView
    lateinit var back: View
    lateinit var more: View
    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //在BaseActivity中声明透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.setFlags(FLAG_TRANSLUCENT_STATUS, FLAG_TRANSLUCENT_STATUS)
        }
        super.setContentView(R.layout.activity_base)
        initTopBar(context)
    }

    override fun setContentView(layoutResID: Int) {
        setContentView(inflate(this, layoutResID, null))
    }

    override fun setContentView(view: View?) {
        root_layout?.apply { addView(view, ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)) }
        initTopBar(context)
    }

    private fun initTopBar(context: Context) {
        var topBar = TopBar(context)
        topBar?.apply { setSupportActionBar(topBar) }
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowTitleEnabled(false)
        }
        title = findViewById(R.id.title)
        back = findViewById(R.id.iv_back)
        more = findViewById(R.id.iv_more)
        onTopBarLeftClick(back, context)
        onTopBarRightClick(more, context)
    }


    fun setTopTitle(msg: String){
        title?.apply {
            visibility = VISIBLE
            text = msg }
    }

    override fun onTopBarLeftClick(leftItemView: View, context: Context) {
        leftItemView?.apply {
            visibility = VISIBLE
            setOnClickListener { finish() }
        }
    }

    override fun onTopBarRightClick(rightItemView: View, context: Context) {
        rightItemView?.apply {
            visibility = VISIBLE
            setOnClickListener{
                intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://github.com/Twila/BaseDemoes")
                startActivity(intent)
            }
        }
    }
}