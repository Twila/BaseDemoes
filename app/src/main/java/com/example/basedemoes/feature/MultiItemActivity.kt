package com.example.basedemoes.feature

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.basedemoes.R
import com.example.basedemoes.base.BaseActivity
import com.example.basedemoes.databinding.LayoutMultiItemBinding
import com.example.basedemoes.view_model.MultiItemViewModel

class MultiItemActivity: BaseActivity<MultiItemViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutMultiItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTopTitle("MultiItemActivity")
        val recyclerView: RecyclerView = findViewById(R.id.multi_item_rv)

    }
}