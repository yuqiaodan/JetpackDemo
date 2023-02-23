package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qiaodan.jetpackdemo.App
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellApiBean
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellItem
import kotlinx.coroutines.launch

/**
 * author: created by yuqiaodan on 2022/12/27 18:56
 * description:
 */
class OnSellViewModel : ViewModel() {

    //当前页
    private var mCurrentPage = 1

    val contentList = MutableLiveData<MutableList<OnShellItem>>()

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
            contentList.postValue(data.tbk_dg_optimus_material_response.result_list.map_data)
        }


    }


}