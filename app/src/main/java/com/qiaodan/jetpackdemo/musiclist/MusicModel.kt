package com.qiaodan.jetpackdemo.musiclist

import com.qiaodan.jetpackdemo.musiclist.data.MusicBean

/**
 * author: created by yuqiaodan on 2022/12/23 17:56
 * description:
 */
class MusicModel {

    fun loadMusicByPage(page: Int, size: Int, callback: OnMusicLoadResult) {
        val result= arrayListOf<MusicBean>()
        Thread{
            for(i in 0 until size){
                result.add(MusicBean("音乐名称: $page-$i","$page-$i","音乐链接：$page-$i"))
            }
            callback.onSuccess(result)
        }.start()
    }

    interface OnMusicLoadResult {
        fun onSuccess(result: List<MusicBean>)


        fun onError(msg: String, code: Int)
    }

}