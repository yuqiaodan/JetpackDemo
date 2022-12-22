package com.qiaodan.jetpackdemo.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.qiaodan.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity(), PlayerContract, View.OnClickListener {

    private val playerPresenter by lazy {
        PlayerPresenter.instance
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        playerPresenter.registerCallback(this)
        setListener()
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

    override fun onTitleChange(title: String) {
        tv_title.text = title
    }

    override fun onProgressChange(current: Int) {
    }

    override fun onPlaying() {
        tv_status.text = "正在播放"


    }

    override fun onMusicPause() {
        tv_status.text = "已暂停"

    }

    override fun onCoverChange(cover: String) {
    }


    override fun onDestroy() {
        super.onDestroy()
        playerPresenter.unregisterCallback(this)
    }


}