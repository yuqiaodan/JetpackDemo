package com.qiaodan.jetpackdemo.player

/**
 * author: created by yuqiaodan on 2022/12/22 22:48
 * description:
 */
class PlayerPresenter private constructor() {


    //单例
    companion object {
        val instance by lazy {
            PlayerPresenter()
        }
    }


    //歌曲列表
    val musicList = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)


    var currentMusic: Int? = null

    enum class PlayStatus {
        NONE,
        PLAYING, PAUSE, LOADING
    }

    private var currentPlayStatus: PlayStatus = PlayStatus.NONE

    private val callbackList = arrayListOf<PlayerContract>()

    fun registerCallback(callback: PlayerContract) {

        if (!callbackList.contains(callback)) {
            callbackList.add(callback)
        }

        if (currentPlayStatus == PlayStatus.PLAYING) {
            disPatchTitleChange("音乐:$currentMusic")
            dispatchPlayingStatus()
        } else {
            disPatchTitleChange("音乐:$currentMusic")
            dispatchPauseStatus()
        }

    }

    fun unregisterCallback(callback: PlayerContract) {
        callbackList.remove(callback)

    }

    fun playOrPause() {

        currentPlayStatus

        if (currentPlayStatus == PlayStatus.NONE) {
            currentMusic = musicList[0]
        }

        if (currentPlayStatus == PlayStatus.PLAYING) {
            currentPlayStatus = PlayStatus.PAUSE
        } else {
            currentPlayStatus = PlayStatus.PLAYING
        }

        if (currentPlayStatus == PlayStatus.PLAYING) {
            disPatchTitleChange("音乐:$currentMusic")
            dispatchPlayingStatus()
        } else {
            dispatchPauseStatus()
        }
    }


    fun playLast() {
        currentMusic = if (currentPlayStatus == PlayStatus.NONE) {
            musicList[0]
        } else {
            if (currentMusic == musicList.first()) {
                musicList.last()
            } else {
                musicList[musicList.indexOf(currentMusic) - 1]
            }
        }
        currentPlayStatus = PlayStatus.PLAYING
        disPatchTitleChange("音乐:$currentMusic")
        dispatchPlayingStatus()
    }


    fun playNext() {
        currentMusic = if (currentPlayStatus == PlayStatus.NONE) {
            musicList[0]
        } else {
            if (currentMusic == musicList.last()) {
                musicList.first()
            } else {
                musicList[musicList.indexOf(currentMusic) + 1]
            }
        }
        disPatchTitleChange("音乐:$currentMusic")
        currentPlayStatus = PlayStatus.PLAYING
        dispatchPlayingStatus()
    }


    private fun dispatchPlayingStatus() {
        callbackList.forEach {
            it.onPlaying()
        }
    }


    private fun dispatchPauseStatus() {
        callbackList.forEach {
            it.onMusicPause()
        }

    }

    private fun disPatchTitleChange(title: String) {
        callbackList.forEach {
            it.onTitleChange(title)
        }
    }

    private fun disPatchCoverChange(cover: String) {
        callbackList.forEach {
            it.onCoverChange(cover)
        }
    }


}