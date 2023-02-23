package com.qiaodan.jetpackdemo.demo3_databinding.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.R

/**
 * author: created by yuqiaodan on 2023/2/23 14:52
 * description:
 */
class NewShellActivity :AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_new_shell)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,NewSellFragment()).commit()
    }
}