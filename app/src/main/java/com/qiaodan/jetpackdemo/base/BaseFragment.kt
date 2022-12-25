package com.qiaodan.jetpackdemo.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.qiaodan.jetpackdemo.lifecycle.LifeCycleProvider
import com.qiaodan.jetpackdemo.lifecycle.LifeState

/**
 * Create by yuqiaodan 2022/12/25
 * Description:
 */
open class BaseFragment:Fragment() {

    val lifeProvider by lazy {
        LifeCycleProvider()
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