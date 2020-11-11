package com.example.basedemoes.feature

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.basedemoes.R
import com.example.basedemoes.base.BaseActivity
import com.example.basedemoes.view_model.ContactViewModel

class ContactsActivity: BaseActivity<ContactViewModel>(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_contact)
    }

    override fun onTopBarRightClick(rightItemView: View, context: Context) {

    }

    override fun onTopBarLeftClick(leftItemView: View, context: Context) {

    }
}