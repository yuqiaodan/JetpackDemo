package com.qiaodan.jetpackdemo.main

import android.util.Log
import androidx.lifecycle.*
import com.qiaodan.jetpackdemo.App

/**
 * author: created by yuqiaodan on 2022/12/26 17:36
 * description:
 *
 * presenter实现LifecycleEventObserver 可以监听生命周期变化
 * presenter实现DefaultLifecycleObserver 可以监听生命周期变化
 * presenter实现LifecycleObserver 后可以通过注解方式监听生命周期变化
 *
 */
class HomePresenter(private val owner: LifecycleOwner) : LifecycleEventObserver, DefaultLifecycleObserver {

    init {
        owner.lifecycle.addObserver(this)
    }

    val liveMusicList = MutableLiveData<List<Int>>()

    var index = 5


    fun flushMusicList() {
        index++
        Thread {
            Thread.sleep(3000L)
            val arrayList = arrayListOf<Int>()
            for (i in 1..index) {
                arrayList.add(i)
            }
            //使用postValue保证在主线程通知观察者此次数据变化
            liveMusicList.postValue(arrayList)
            Log.d(App.TAG, "HomePresenter flushMusicList 生成最新List: $arrayList")
        }.start()


    }

    /**
     * View层生命周期变化 presenter被动接收
     * 通过接口处理
     * */
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d(App.TAG, "HomePresenter ON_CREATE")
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d(App.TAG, "HomePresenter ON_PAUSE")
            }

            Lifecycle.Event.ON_START -> {
                Log.d(App.TAG, "HomePresenter ON_START")
            }

            Lifecycle.Event.ON_STOP -> {
                Log.d(App.TAG, "HomePresenter ON_STOP")
            }
            Lifecycle.Event.ON_DESTROY -> {
                Log.d(App.TAG, "HomePresenter ON_DESTROY")
            }
            else -> {

            }
        }
    }


    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
    }

    //注解方式添加 不推荐 因为要通过反射进行， 但是要知道有这种用法
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {

    }


}