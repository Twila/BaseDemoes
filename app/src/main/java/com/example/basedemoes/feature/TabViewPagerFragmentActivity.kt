package com.example.basedemoes.feature

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basedemoes.databinding.LayoutTabViewpagerBinding

class TabViewPagerFragmentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val binding = LayoutTabViewpagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}