package com.qiaodan.jetpackdemo.demo3_databinding.mvvm.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * author: created by yuqiaodan on 2023/2/21 17:46
 * description:
 */
abstract class BaseViewModelFragment<V : ViewDataBinding, VM : ViewModel> : BaseViewFragment<V>() {

    protected lateinit var viewModel: VM

    /**
     * 界面创建完成 三步顺序
     * 第一步：初始化ViewModel initViewModel()
     * 第二步：初始化业务层View内容initView() （可能会用到第一步的viewModel所以必须在第二步）
     * 第三步：添加数据观察observerData()     (可能需要填充并覆盖一些初始化界面内容 放在第三步)
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        super.onViewCreated(view, savedInstanceState)
        initDataObserver()
    }

    /**
     * 初始化viewmodel
     * */
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(getSubVmClass())
    }

    /**
     * 获取子类指定ViewModel Class
     * */
    abstract fun getSubVmClass(): Class<VM>

    /**
     * 设置数据观察
     * */
    open fun initDataObserver(){}



}