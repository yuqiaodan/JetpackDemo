package com.qiaodan.jetpackdemo.demo1_livedata.custom.lifecycle

interface ILiftCycleObserver {
    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}