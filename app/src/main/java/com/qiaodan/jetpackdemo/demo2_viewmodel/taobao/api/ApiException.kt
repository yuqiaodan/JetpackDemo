package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api

/**
 * author: created by yuqiaodan on 2022/12/28 18:33
 * description:
 */
data class ApiException(val code:Int,val msg:String):RuntimeException() {
}