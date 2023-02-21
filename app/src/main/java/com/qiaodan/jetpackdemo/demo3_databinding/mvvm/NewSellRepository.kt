package com.qiaodan.jetpackdemo.demo3_databinding.mvvm

import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.RetrofitClient
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellApiBean

/**
 * author: created by yuqiaodan on 2023/2/21 18:02
 * description:
 */
class NewSellRepository {

    suspend fun getOnShellList(page: Int): OnShellApiBean {
        return RetrofitClient.apiService.getOnSellList(page).apiData()
    }

}