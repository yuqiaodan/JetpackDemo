package com.qiaodan.jetpackdemo.musiclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qiaodan.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : AppCompatActivity() {

    private val musicPresenter by lazy {
        MusicPresenter()
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