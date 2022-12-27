package com.qiaodan.jetpackdemo.taobao

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author: created by yuqiaodan on 2022/12/27 18:56
 * description:
 */
class OnSellViewModel : ViewModel() {

    val contentList = MutableLiveData<MutableList<String>>()


}