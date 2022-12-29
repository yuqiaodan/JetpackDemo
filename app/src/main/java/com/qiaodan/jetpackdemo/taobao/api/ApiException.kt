package com.qiaodan.jetpackdemo.taobao.api

import java.util.concurrent.TimeoutException

/**
 * author: created by yuqiaodan on 2022/12/28 18:33
 * description:
 */
data class ApiException(val code:Int,val msg:String):RuntimeException() {
}