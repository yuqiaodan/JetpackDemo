package com.qiaodan.jetpackdemo.player

/**
 * author: created by yuqiaodan on 2022/12/22 22:47
 * description:
 */
interface PlayerContract {

    fun onTitleChange(title: String)

    fun onProgressChange(current: Int)

    fun onPlaying()

    fun onMusicPause()

    //封面改变
    fun onCoverChange(cover: String)

}