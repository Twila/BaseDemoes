package com.example.basedemoes.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.example.basedemoes.widget.TopBar

abstract class BaseActivity<V: ViewDataBinding, VM: BaseViewModel>: FragmentActivity(), TopBar.OnTopBarEventListener{
}