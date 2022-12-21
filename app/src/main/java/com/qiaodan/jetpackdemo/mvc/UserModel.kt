package com.qiaodan.jetpackdemo.mvc

import java.util.Random

/**
 * author: created by yuqiaodan on 2022/12/21 23:16
 * description:用户Model
 */
class UserModel {

    val api by lazy {
        Api()
    }

    fun doLogin(callback: LoginCallback) {
        callback.onLoading()
        val value: Int = Random().nextInt(2)

        when (value) {
            0 -> {
                callback.onLoginFail()
            }
            1 -> {
                callback.onLoginSuccess()
            }

        }


    }


    fun checkUserStatus(account:String,block: (Int) -> Unit) {


        //1-已登录 0-未登录
        block.invoke(Random().nextInt(2))


    }


    interface LoginCallback {

        fun onLoading()

        fun onLoginSuccess()

        fun onLoginFail()
    }


}