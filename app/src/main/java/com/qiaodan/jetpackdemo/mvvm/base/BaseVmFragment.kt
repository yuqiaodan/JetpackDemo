package com.qiaodan.jetpackdemo.binding.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Create by yuqiaodan 2023/1/8
 * Description:
 */
abstract class BaseVmFragment<T : ViewDataBinding,VM: ViewModel> : BaseBindFragment<T>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //创建viewmodel

    }

    abstract fun getSubVmClass():Class<VM>

    private fun initViewModel(){
        ViewModelProvider(this).get()
    }
}