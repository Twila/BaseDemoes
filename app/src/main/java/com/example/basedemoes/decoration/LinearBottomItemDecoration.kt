package com.example.basedemoes.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LinearBottomItemDecoration(val offSet: Int): RecyclerView.ItemDecoration() {
    init {
        val offSet = offSet
    }

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State,
    ) {
        val childAdapterPosition = parent.getChildAdapterPosition(view)
        val linearLayoutManager = parent.layoutManager as LinearLayoutManager?
        if (linearLayoutManager!!.orientation != LinearLayoutManager.VERTICAL) {
        } else {
            if (childAdapterPosition == 0) {
                outRect.top = offSet
            }
            outRect.bottom = offSet
        }
    }
}