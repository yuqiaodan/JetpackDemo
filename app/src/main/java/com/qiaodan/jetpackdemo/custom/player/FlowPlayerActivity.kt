package com.qiaodan.jetpackdemo.custom.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.qiaodan.jetpackdemo.App
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.home.LivePlayerState
import kotlinx.android.synthetic.main.activity_player_flow.*

/**
 * MVP缺点:
 * 多个地方使用同一个presenter，则需要实现指定接口
 * FlowPlayerActivity小播放器也要控制音乐播放、暂停 但不需要显示封面和标题等
 *
 * 就出现了很多无用实现
 *
 * */

class FlowPlayerActivity : AppCompatActivity() {

    private val playerPresenter by lazy {
        PlayerPresenter.instance
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_flow)

        btn_play_flow.setOnClickListener {
            playerPresenter.playOrPause()
        }

        playerPresenter.currentPlayStatus.addListener {
            when (it) {
                PlayerPresenter.PlayStatus.PLAYING -> {
                    btn_play_flow.text = "播放中 点击暂停"
                }

                PlayerPresenter.PlayStatus.PAUSE -> {
                    btn_play_flow.text = "暂停中 点击播放"
                }

                else -> {}
            }
        }
        initDataObserver()
    }


    private fun initDataObserver(){
        btn_play_home.setOnClickListener {
            if(LivePlayerState.instance.value==PlayerPresenter.PlayStatus.PLAYING){
                LivePlayerState.instance.postValue(PlayerPresenter.PlayStatus.PAUSE)
            }else{
                LivePlayerState.instance.postValue(PlayerPresenter.PlayStatus.PLAYING)

            }
        }

        LivePlayerState.instance.observe(this,object :Observer<PlayerPresenter.PlayStatus>{
            override fun onChanged(t: PlayerPresenter.PlayStatus?) {
                Log.d(App.TAG, "FlowPlayerActivity 播放状态变化：${t}")

                when (t) {
                    PlayerPresenter.PlayStatus.PLAYING -> {
                        btn_play_home.text = "播放中 点击暂停"
                    }

                    PlayerPresenter.PlayStatus.PAUSE -> {
                        btn_play_home.text = "暂停中 点击播放"
                    }
                    else -> {}
                }
            }
        })




    }


}