package com.qiaodan.jetpackdemo.custom.player

import com.qiaodan.jetpackdemo.custom.lifecycle.ILiftCycleObserver
import com.qiaodan.jetpackdemo.custom.musiclist.DataListenerContainer


/**
 * author: created by yuqiaodan on 2022/12/22 22:48
 * description:
 *
 *
 *
 *
 */
class PlayerPresenter private constructor() : ILiftCycleObserver {

    //歌曲列表
    private val musicList = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    var currentMusic = DataListenerContainer<Int>()

    var currentPlayStatus = DataListenerContainer<PlayStatus>()

    //单例
    companion object {
        val instance by lazy {
            PlayerPresenter()
        }
    }

    enum class PlayStatus {
        NONE,
        PLAYING,
        PAUSE,
        LOADING
    }

    fun playOrPause() {
        if (currentPlayStatus.value == null) {
            currentMusic.value = musicList[0]
        }

        if (currentPlayStatus.value == PlayStatus.PLAYING) {
            currentPlayStatus.value = PlayStatus.PAUSE
        } else {
            currentPlayStatus.value = PlayStatus.PLAYING
        }
    }

    fun playLast() {
        currentMusic.value = if (currentPlayStatus.value == null) {
            musicList[0]
        } else {
            if (currentMusic.value == musicList.first()) {
                musicList.last()
            } else {
                musicList[musicList.indexOf(currentMusic.value) - 1]
            }
        }
        currentPlayStatus.value = PlayStatus.PLAYING

    }

    fun playNext() {
        currentMusic.value = if (currentPlayStatus.value == null) {
            musicList[0]
        } else {
            if (currentMusic.value == musicList.last()) {
                musicList.first()
            } else {
                musicList[musicList.indexOf(currentMusic.value) + 1]
            }
        }
        currentPlayStatus.value = PlayStatus.PLAYING
    }

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
    }


}