package com.example.basedemoes.feature.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.basedemoes.R
import kotlinx.android.synthetic.main.simple_image_fragment.view.*

class SimpleImageFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {
    private var contentLayoutId = contentLayoutId

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.simple_image_fragment, null)
        view.image_fragment.setImageResource(contentLayoutId)
        return view
    }

}