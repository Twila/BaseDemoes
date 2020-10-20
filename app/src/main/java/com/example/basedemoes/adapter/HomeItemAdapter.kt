package com.example.basedemoes.adapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.basedemoes.R
import com.example.basedemoes.entity.ItemEntity

class HomeItemAdapter(data: MutableList<ItemEntity>) : BaseQuickAdapter<ItemEntity, BaseViewHolder>(R.layout.item_demo, data){
    override fun convert(holder: BaseViewHolder, item: ItemEntity) {
        holder.setText(R.id.tv_demo, item.name)
        holder.setImageResource(R.id.iv_demo, item.imageSrc)
    }

}