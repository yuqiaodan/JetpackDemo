package com.qiaodan.jetpackdemo.demo1_livedata.custom.musiclist

import com.qiaodan.jetpackdemo.demo1_livedata.custom.lifecycle.ILifecycleOwner
import com.qiaodan.jetpackdemo.demo1_livedata.custom.lifecycle.ILiftCycleObserver
import com.qiaodan.jetpackdemo.demo1_livedata.custom.musiclist.data.MusicBean

/**
 * author: created by yuqiaodan on 2022/12/23 17:56
 * description:自定义
 */
class MusicPresenter(owner: ILifecycleOwner) {

    private val musicModel by lazy {
        MusicModel()
    }

    private val viewLifeImpl by lazy {
        ViewLifeImpl()
    }


    init {
        owner.getLifecycleProvider().addLifeListener(viewLifeImpl)
    }

    enum class MusicLoadStatus {

        LOADING, EMPTY, SUCCESS, ERROR

    }

    val musicList = DataListenerContainer<List<MusicBean>>()

    val loadStatus = DataListenerContainer<MusicLoadStatus>()

    private var page = 1
    private var size = 30

    fun getMusic() {
        loadStatus.value = MusicLoadStatus.LOADING
        musicModel.loadMusicByPage(page, size, object : MusicModel.OnMusicLoadResult {
            override fun onSuccess(result: List<MusicBean>) {
                musicList.value = result
                loadStatus.value = if (result.isEmpty()) {
                    MusicLoadStatus.EMPTY
                } else {
                    MusicLoadStatus.SUCCESS
                }
            }

            override fun onError(msg: String, code: Int) {
                loadStatus.value = MusicLoadStatus.ERROR
            }
        })
    }


    inner class ViewLifeImpl : ILiftCycleObserver {
        //绑定presenter和activity的生命周期
        override fun onCreate() {
            println("MusicPresenter onCreate")
        }

        override fun onStart() {
            println("MusicPresenter onStart")

        }

        override fun onResume() {
            println("MusicPresenter onResume")

        }

        override fun onPause() {
            println("MusicPresenter onPause")
        }

        override fun onStop() {
            println("MusicPresenter onStop")
        }

        override fun onDestroy() {
            println("MusicPresenter onDestroy")
        }


    }

}