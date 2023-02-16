package com.qiaodan.jetpackdemo.demo1_livedata.home

import androidx.lifecycle.LiveData
import com.qiaodan.jetpackdemo.demo1_livedata.custom.player.PlayerPresenter

/**
 * author: created by yuqiaodan on 2022/12/26 19:25
 * description:采用单例模式 完成数据共享
 */
class LivePlayerState private constructor() : LiveData<PlayerPresenter.PlayStatus>() {

    companion object {
        val instance by lazy {
            LivePlayerState()
        }
    }

    //放出postValue方法
    public override fun postValue(value: PlayerPresenter.PlayStatus?) {
        super.postValue(value)
    }

}