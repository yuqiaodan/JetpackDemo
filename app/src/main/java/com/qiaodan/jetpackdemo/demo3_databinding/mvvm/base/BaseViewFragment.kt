package com.qiaodan.jetpackdemo.demo3_databinding.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.adapters.ViewBindingAdapter
import androidx.fragment.app.Fragment

/**
 * author: created by yuqiaodan on 2023/2/21 17:29
 * description:
 */
abstract class BaseViewFragment<V : ViewDataBinding> : Fragment() {

    protected lateinit var binding: V


    abstract fun getSubLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //加载方式一：DataBindingUtil.bind
        /* val view = inflater.inflate(getSubLayoutId(), container, false)
         binding = DataBindingUtil.bind<T>(view)*/

        //加载方式二：DataBindingUtil.inflate
        binding = DataBindingUtil.inflate<V>(inflater, getSubLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    open fun initView() {}

}