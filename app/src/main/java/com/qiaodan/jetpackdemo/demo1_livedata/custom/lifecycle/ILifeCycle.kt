package com.qiaodan.jetpackdemo.demo1_livedata.custom.lifecycle

/***
 * 管理所有注册进来的ILifeCycle接口
 * 保存当前View的生命周期状态
 * */
class ILifeCycle {

    private var currentState: ILifeState? = null

    //因为一个View可能存在多个Presenter 所以这里用集合 可以添加多个ILiftCycle
    private val lifecycleListener = arrayListOf<ILiftCycleObserver>()

    fun addLifeListener(listener: ILiftCycleObserver) {
        if (!lifecycleListener.contains(listener)) {
            lifecycleListener.add(listener)
        }
    }

    fun removeLifeListener(listener: ILiftCycleObserver) {
        lifecycleListener.remove(listener)
    }

    fun makeLifeState(state: ILifeState) {
        currentState = state
        when (state) {
            ILifeState.CREATE -> {
                lifecycleListener.forEach {
                    it.onCreate()
                }
            }
            ILifeState.START -> {
                lifecycleListener.forEach {
                    it.onStart()
                }
            }
            ILifeState.RESUME -> {
                lifecycleListener.forEach {
                    it.onResume()
                }
            }
            ILifeState.PAUSE -> {
                lifecycleListener.forEach {
                    it.onPause()
                }
            }
            ILifeState.STOP -> {
                lifecycleListener.forEach {
                    it.onStop()
                }
            }
            ILifeState.DESTROY -> {
                lifecycleListener.forEach {
                    it.onDestroy()
                }
                lifecycleListener.clear()
            }
        }

    }


}