package com.qiaodan.jetpackdemo.demo3_databinding.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Create by yuqiaodan 2023/1/8
 * Description:普通base fragment
 */
abstract class BaseFragment : Fragment() {

    protected lateinit var mView: View

    abstract fun getSubLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(getSubLayoutId(), container, false)
        return mView
    }

}