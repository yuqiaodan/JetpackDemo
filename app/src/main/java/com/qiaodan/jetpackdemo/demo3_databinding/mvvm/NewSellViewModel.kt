package com.qiaodan.jetpackdemo.demo3_databinding.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellItem
import kotlinx.coroutines.launch

/**
 * author: created by yuqiaodan on 2023/2/21 17:56
 * description:
 */
class NewSellViewModel : ViewModel() {

    //业务层关心的数据

    //加载状态
    val loadState: MutableLiveData<LoadState> by lazy {
        MutableLiveData<LoadState>()
    }

    //填充数据内容
    val contentList: MutableLiveData<MutableList<OnShellItem>> by lazy {
        MutableLiveData<MutableList<OnShellItem>>()
    }


    //当前加载页码
    private var mCurrentPage = 1

    private val repository by lazy {
        NewSellRepository()
    }


    fun loadData() {
        loadState.postValue(LoadState.LOADING)
        loadDataByPage(mCurrentPage)
    }


    private fun loadDataByPage(page: Int) {
        viewModelScope.launch {
            try {
                val result = repository.getOnShellList(page)
                Log.d("NewSellTag", "code:${result.code}")
                Log.d("NewSellTag", "message:${result.message}")
                Log.d("NewSellTag", "data:${result.data.tbk_dg_optimus_material_response.result_list}")
                val dataList=result.data.tbk_dg_optimus_material_response.result_list.map_data
                if(dataList.isEmpty()){
                    loadState.postValue(LoadState.EMPTY)
                }else{
                    contentList.postValue(dataList)
                    loadState.postValue(LoadState.SUCCESS)
                }
            }catch (e:Exception){
                loadState.postValue(LoadState.ERROR)
            }
        }
    }


    enum class LoadState {
        LOADING,
        SUCCESS,
        EMPTY,
        ERROR,
        NONE
    }
}