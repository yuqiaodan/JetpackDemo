package com.qiaodan.jetpackdemo.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.App
import androidx.lifecycle.Observer
import com.qiaodan.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_home.*

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
        setContentView(R.layout.activity_home)
        initView()
        initDataObserver()
    }

    private fun initView() {
        btn_get_music_list.setOnClickListener { presenter.flushMusicList() }

    }

    private fun initDataObserver() {
        /***
         * observe  只在界面可交互（onStart onResume）时才会收到数据变化，界面恢复可交互时也会收到最新的数据变化，销毁时自动清除观察者
         * observeForever 任何时候都会收到数据变化，销毁时需要手动removeObserver清除观察者
         * */

        presenter.liveMusicList.observe(this, object : Observer<List<Int>> {
            override fun onChanged(list: List<Int>?) {
                Log.d(App.TAG, "HomeActivity 收到数据变化${list.toString()}")
                tv_music_list.text = list.toString()
            }
        })


        presenter.liveMusicList.observeForever(observerForever)

    }


    private val observerForever = object : Observer<List<Int>> {
        override fun onChanged(list: List<Int>?) {
            Log.d(App.TAG, "HomeActivity Observer forever 收到数据变化${list.toString()}")

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.liveMusicList.removeObserver(observerForever)
    }

}