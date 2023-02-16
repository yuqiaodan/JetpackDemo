package com.qiaodan.jetpackdemo.demo1_livedata.custom.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.demo1_livedata.custom.lifecycle.ILifecycleOwner
import com.qiaodan.jetpackdemo.demo1_livedata.custom.lifecycle.ILifeCycle
import com.qiaodan.jetpackdemo.demo1_livedata.custom.lifecycle.ILifeState

open class TestBaseActivity : AppCompatActivity(), ILifecycleOwner {

    val lifeProvider by lazy {
        ILifeCycle()
    }

    override fun getLifecycleProvider(): ILifeCycle {
        return lifeProvider
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeProvider.makeLifeState(ILifeState.CREATE)
    }

    override fun onStart() {
        super.onStart()
        lifeProvider.makeLifeState(ILifeState.START)
    }

    override fun onResume() {
        super.onResume()
        lifeProvider.makeLifeState(ILifeState.RESUME)
    }

    override fun onPause() {
        super.onPause()
        lifeProvider.makeLifeState(ILifeState.PAUSE)
    }

    override fun onStop() {
        super.onStop()
        lifeProvider.makeLifeState(ILifeState.STOP)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeProvider.makeLifeState(ILifeState.DESTROY)
    }


}