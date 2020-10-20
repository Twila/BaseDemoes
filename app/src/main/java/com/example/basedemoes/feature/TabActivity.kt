package com.example.basedemoes.feature

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basedemoes.databinding.LayoutTabBinding

class TabActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutTabBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}