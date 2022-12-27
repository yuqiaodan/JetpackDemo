package com.qiaodan.jetpackdemo.taobao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.qiaodan.jetpackdemo.R

class OnSellActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        val viewModel = ViewModelProvider(this).get(OnSellViewModel::class.java)





    }


}