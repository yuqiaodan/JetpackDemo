package com.qiaodan.jetpackdemo.lifecycle

interface ILiftCycle {
    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}