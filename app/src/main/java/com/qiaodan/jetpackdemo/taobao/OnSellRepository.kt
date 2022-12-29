package com.qiaodan.jetpackdemo.taobao

import com.qiaodan.jetpackdemo.taobao.api.RetrofitClient
import com.qiaodan.jetpackdemo.taobao.api.bean.OneShellBean

/**
 * author: created by yuqiaodan on 2022/12/27 19:29
 * description:
 */
class OnSellRepository {

    suspend fun getOnShellList(page: Int): OneShellBean {
        return RetrofitClient.apiService.getOnSellList(page).apiData()
    }


}