package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao

import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.RetrofitClient
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellApiBean

/**
 * author: created by yuqiaodan on 2022/12/27 19:29
 * description:
 */
class OnSellRepository {

    suspend fun getOnShellList(page: Int): OnShellApiBean {
        return RetrofitClient.apiService.getOnSellList(page).data
    }


}