package com.qiaodan.jetpackdemo.custom.musiclist

import android.os.Bundle
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.custom.base.TestBaseActivity
import kotlinx.android.synthetic.main.activity_music.*


/**
 * Activity生命周期
 * onCreate 创建 还不可见
 * onStart 可见 不可交互
 * onResume 可见 可交互
 * onPause 可见 不可交互
 * onStop 不可见 不可交互
 * onDestroy 销毁
 * */
class MusicActivityTest : TestBaseActivity(){


    private val musicPresenter by lazy {
        MusicPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initViewListener()
        initDataListener()
    }


    private fun initDataListener() {
        musicPresenter.musicList.addListener {
            //监听音乐列表状态变化
            println("音乐列表加载成功 当前线程：${Thread.currentThread().name}   列表长度：${it?.size}")
            tv_music_list.text = "$it"
        }

        musicPresenter.loadStatus.addListener {
            //数据状态
            println("音乐列表加载状态 当前线程：${Thread.currentThread().name}   状态：${it}")

        }
    }

    private fun initViewListener() {
        btn_get_music_list.setOnClickListener {
            musicPresenter.getMusic()
        }
    }




}