package com.qiaodan.jetpackdemo.demo1_livedata.custom.player

import android.os.Bundle
import android.view.View
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.demo1_livedata.custom.base.TestBaseActivity
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivityTest : TestBaseActivity(), View.OnClickListener {

    private val playerPresenter by lazy {
        PlayerPresenter.instance
    }

    init {
        lifeProvider.addLifeListener(playerPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        setListener()
        initDataListener()
    }


    private fun initDataListener() {
        //数据监听 监听音乐变化
        playerPresenter.currentMusic.addListener { musicTitle ->
            tv_title.text = "歌曲：$musicTitle"
        }


        //数据监听 监听状态变化
        playerPresenter.currentPlayStatus.addListener { status ->
            when (status) {
                PlayerPresenter.PlayStatus.PLAYING -> {
                    tv_status.text = "正在播放"
                }

                PlayerPresenter.PlayStatus.PAUSE -> {
                    tv_status.text = "已暂停"

                }

                else -> {}
            }
        }
    }


    private fun setListener() {

        btn_play.setOnClickListener(this)

        btn_last.setOnClickListener(this)

        btn_next.setOnClickListener(this)


    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_play -> {
                playerPresenter.playOrPause()
            }
            R.id.btn_last -> {
                playerPresenter.playLast()
            }
            R.id.btn_next -> {
                playerPresenter.playNext()
            }
        }

    }


}