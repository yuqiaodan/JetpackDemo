package com.qiaodan.jetpackdemo.taobao

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.qiaodan.jetpackdemo.App
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * author: created by yuqiaodan on 2022/12/27 18:56
 * description:
 */
class OnSellViewModel : ViewModel() {

    //当前页
    private var mCurrentPage = 1

    val contentList = MutableLiveData<MutableList<String>>()

    private val onShellRepository by lazy {
        OnSellRepository()
    }


    /***
     * 加载特惠页面内容
     * */
    fun loadContent() {


        this.loadContentByPage(mCurrentPage)
    }


    fun loadMore() {


    }


    private fun loadContentByPage(page: Int) {


        viewModelScope.launch {
            val data = onShellRepository.getOnShellList(page)
            Log.d(App.TAG, "请求到数据 $data")

        }


    }


}