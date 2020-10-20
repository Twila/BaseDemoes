package com.example.basedemoes.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basedemoes.databinding.LayoutChatBinding

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LayoutChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}