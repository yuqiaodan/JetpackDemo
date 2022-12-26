package com.qiaodan.jetpackdemo.main

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.App

/**
 * author: created by yuqiaodan on 2022/12/26 17:36
 * description:
 */
class HomeActivity : AppCompatActivity() {

    private val presenter by lazy {
        HomePresenter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(App.TAG, "HomeActivity onCreate")
        presenter
    }


    override fun onResume() {
        super.onResume()
        presenter.test()
    }
}