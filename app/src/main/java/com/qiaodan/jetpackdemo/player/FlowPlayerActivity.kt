package com.qiaodan.jetpackdemo.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qiaodan.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_player_flow.*

/**
 * MVP缺点:
 * 多个地方使用同一个presenter，则需要实现指定接口
 * FlowPlayerActivity小播放器也要控制音乐播放、暂停 但不需要显示封面和标题等
 *
 * 就出现了很多无用实现
 *
 * */

class FlowPlayerActivity : AppCompatActivity(), PlayerContract {

    private val playerPresenter by lazy {
        PlayerPresenter.instance
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_flow)
        playerPresenter.registerCallback(this)
        btn_play_flow.setOnClickListener {
            playerPresenter.playOrPause()
        }

    }


    override fun onPlaying() {
        btn_play_flow.text = "播放中 点击暂停"
    }

    override fun onMusicPause() {
        btn_play_flow.text = "暂停中 点击播放"
    }


    override fun onTitleChange(title: String) {

    }

    override fun onProgressChange(current: Int) {
    }

    override fun onCoverChange(cover: String) {
    }


    override fun onDestroy() {
        super.onDestroy()
        playerPresenter.unregisterCallback(this)
    }
}