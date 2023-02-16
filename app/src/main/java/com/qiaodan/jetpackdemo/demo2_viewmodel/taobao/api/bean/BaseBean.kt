package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean

import com.google.gson.annotations.SerializedName
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.ApiException

/**
 * author: created by yuqiaodan on 2022/12/28 18:06
 * description:
 */
data class BaseBean<T>(
    val code: Int,
    @SerializedName("data")
    val content: T,
    val message: String,
    val success: Boolean
){
    companion object{
        const val SUCCESS_CODE=10000
    }

    fun apiData():T{
        if(code== SUCCESS_CODE){
            return content
        }else{
            throw ApiException(code,message)
        }
    }
}