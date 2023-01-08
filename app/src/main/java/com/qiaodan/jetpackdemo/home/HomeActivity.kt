package com.qiaodan.jetpackdemo.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.App
import androidx.lifecycle.Observer
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.custom.player.PlayerPresenter
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



        btn_play.setOnClickListener {
            if (LivePlayerState.instance.value == PlayerPresenter.PlayStatus.PLAYING) {
                LivePlayerState.instance.postValue(PlayerPresenter.PlayStatus.PAUSE)
            } else {
                LivePlayerState.instance.postValue(PlayerPresenter.PlayStatus.PLAYING)

            }
        }

        LivePlayerState.instance.observe(this,object :Observer<PlayerPresenter.PlayStatus>{
            override fun onChanged(t: PlayerPresenter.PlayStatus?) {
                Log.d(App.TAG, "HomeActivity 播放状态变化：${t}")

                when (t) {
                    PlayerPresenter.PlayStatus.PLAYING -> {
                        btn_play.text = "播放中 点击暂停"
                    }

                    PlayerPresenter.PlayStatus.PAUSE -> {
                        btn_play.text = "暂停中 点击播放"
                    }
                    else -> {}
                }
            }
        })


    }

    private fun initDataObserver() {
        /***
         * observe  只在界面可交互（onStart onResume）时才会收到数据变化，界面恢复可交互时也会收到最新的数据变化，销毁时自动清除观察者
         * observeForever 任何时候都会收到数据变化，销毁时需要手动removeObserver清除观察者
         * */

        presenter.liveMusicList.observe(this, object : Observer<List<Int>> {
            override fun onChanged(list: List<Int>?) {
                Log.d(App.TAG, "HomeActivity 收到数据变化${list.toString()}  ")
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