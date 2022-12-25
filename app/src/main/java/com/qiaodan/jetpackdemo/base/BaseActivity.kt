package com.qiaodan.jetpackdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.lifecycle.ILifecycleOwner
import com.qiaodan.jetpackdemo.lifecycle.ILiftCycle
import com.qiaodan.jetpackdemo.lifecycle.LifeCycleProvider
import com.qiaodan.jetpackdemo.lifecycle.LifeState

open class BaseActivity : AppCompatActivity(), ILifecycleOwner {

    val lifeProvider by lazy {
        LifeCycleProvider()
    }

    override fun getLifecycleProvider(): LifeCycleProvider {
        return lifeProvider
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeProvider.makeLifeState(LifeState.CREATE)
    }

    override fun onStart() {
        super.onStart()
        lifeProvider.makeLifeState(LifeState.START)
    }

    override fun onResume() {
        super.onResume()
        lifeProvider.makeLifeState(LifeState.RESUME)
    }

    override fun onPause() {
        super.onPause()
        lifeProvider.makeLifeState(LifeState.PAUSE)
    }

    override fun onStop() {
        super.onStop()
        lifeProvider.makeLifeState(LifeState.STOP)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeProvider.makeLifeState(LifeState.DESTROY)
    }


}