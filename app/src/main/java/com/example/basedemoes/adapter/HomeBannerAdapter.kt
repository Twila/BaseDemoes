package com.example.basedemoes.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.basedemoes.entity.BannerEntity
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils

class HomeBannerAdapter(data: MutableList<BannerEntity>) : BannerAdapter<BannerEntity, HomeBannerAdapter.ImageHolder>(data) {
    class ImageHolder(view: View) : RecyclerView.ViewHolder(view){
        var imgView: ImageView = view as ImageView
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int) : ImageHolder{
        val imgView = ImageView(parent?.context)
        imgView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imgView.scaleType = ImageView.ScaleType.CENTER_CROP
        imgView.elevation = 3.0F

        //图片圆角剪裁
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            BannerUtils.setBannerRound(imgView, 20f)
        }
        return ImageHolder(imgView)
    }

    override fun onBindView(holder: ImageHolder?, data: BannerEntity?, position: Int, size: Int) {
        Glide.with(holder!!.itemView)
            .load(data?.imgRes)
            .placeholder(ColorDrawable(Color.GRAY))
            .into(holder?.imgView)
    }
}