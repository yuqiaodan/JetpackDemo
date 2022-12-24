package com.qiaodan.jetpackdemo.musiclist

import com.qiaodan.jetpackdemo.musiclist.data.MusicBean
import com.qiaodan.jetpackdemo.player.DataListenerContainer

/**
 * author: created by yuqiaodan on 2022/12/23 17:56
 * description:
 */
class MusicPresenter {

    private val musicModel by lazy {
        MusicModel()
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

}