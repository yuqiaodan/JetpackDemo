package com.qiaodan.jetpackdemo.demo3_databinding.mvvm

import android.util.Log
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.databinding.FragmentNewSellBinding
import com.qiaodan.jetpackdemo.demo3_databinding.mvvm.base.BaseViewModelFragment

/**
 * author: created by yuqiaodan on 2023/2/21 17:53
 * description:
 */
class NewSellFragment:BaseViewModelFragment<FragmentNewSellBinding, NewSellViewModel>() {
    override fun getSubLayoutId(): Int {
     return R.layout.fragment_new_sell
    }

    override fun getSubVmClass(): Class<NewSellViewModel> {
        return NewSellViewModel::class.java
    }


    override fun initView() {
        super.initView()



    }


    override fun observerData() {
        super.observerData()

        viewModel.contentList.observe(this){

            Log.d("NewSellTag","")



        }


        viewModel.loadState.observe(this){state->

            Log.d("NewSellTag","LoadState--->$state")

        }

    }
}