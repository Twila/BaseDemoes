package com.example.basedemoes.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.example.basedemoes.R
import java.time.format.DecimalStyle
import java.util.jar.Attributes

open class SiderBar(context: Context, attrs: AttributeSet?, defStyleAttr: Int): View(context, attrs, defStyleAttr) {
    private var textColor = 0
    private var textSize = 0.0f

    constructor(context: Context, attrs: AttributeSet): this(context, attrs, 0){
        init(context, attrs)
    }
    constructor(context: Context): this(context, null, 0)

    private fun init(context: Context, attrs: AttributeSet){
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.side_bar)
    }

}