package com.qiaodan.jetpackdemo.custom.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.custom.lifecycle.ILifecycleOwner
import com.qiaodan.jetpackdemo.custom.lifecycle.ILifeCycle
import com.qiaodan.jetpackdemo.custom.lifecycle.ILifeState

open class BaseActivity : AppCompatActivity(), ILifecycleOwner {

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