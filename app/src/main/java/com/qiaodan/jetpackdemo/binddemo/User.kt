package com.qiaodan.jetpackdemo.binddemo

/**
 * Create by yuqiaodan 2023/1/8
 * Description:
 */
data class User(
    val name:String,
    val age:Int,
    val gender: Gender

) {
    enum class Gender{
        MAN,WOMAN
    }

}