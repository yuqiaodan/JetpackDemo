package com.qiaodan.jetpackdemo.demo3_databinding.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Create by yuqiaodan 2023/1/8
 * Description: databing base fragment
 */
abstract class BaseBindFragment<T : ViewDataBinding> : BaseFragment() {



    protected lateinit var binding: T


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getSubLayoutId(), container, false)
        //binding = DataBindingUtil.bind<T>(view)
        binding = DataBindingUtil.inflate<T>(inflater, getSubLayoutId(), container, false)
        return binding.root
    }


}