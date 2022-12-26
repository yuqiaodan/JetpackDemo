package com.qiaodan.jetpackdemo.custom.lifecycle

/***
 * 管理所有注册进来的ILifeCycle接口
 * 保存当前View的生命周期状态
 * */
class LifeCycleProvider {

    private var currentState: LifeState? = null

    //因为一个View可能存在多个Presenter 所以这里用集合 可以添加多个ILiftCycle
    private val lifecycleListener = arrayListOf<ILiftCycle>()

    fun addLifeListener(listener: ILiftCycle) {
        if (!lifecycleListener.contains(listener)) {
            lifecycleListener.add(listener)
        }
    }

    fun removeLifeListener(listener: ILiftCycle) {
        lifecycleListener.remove(listener)
    }

    fun makeLifeState(state: LifeState) {
        currentState = state
        when (state) {
            LifeState.CREATE -> {
                lifecycleListener.forEach {
                    it.onCreate()
                }
            }
            LifeState.START -> {
                lifecycleListener.forEach {
                    it.onStart()
                }
            }
            LifeState.RESUME -> {
                lifecycleListener.forEach {
                    it.onResume()
                }
            }
            LifeState.PAUSE -> {
                lifecycleListener.forEach {
                    it.onPause()
                }
            }
            LifeState.STOP -> {
                lifecycleListener.forEach {
                    it.onStop()
                }
            }
            LifeState.DESTROY -> {
                lifecycleListener.forEach {
                    it.onDestroy()
                }
                lifecycleListener.clear()
            }
        }

    }


}