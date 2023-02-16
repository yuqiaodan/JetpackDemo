package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao

import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.RetrofitClient
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellBean

/**
 * author: created by yuqiaodan on 2022/12/27 19:29
 * description:
 */
class OnSellRepository {

    suspend fun getOnShellList(page: Int): OnShellBean {
        return RetrofitClient.apiService.getOnSellList(page).apiData()
    }


}