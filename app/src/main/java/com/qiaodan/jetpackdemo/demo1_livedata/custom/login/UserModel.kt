package com.qiaodan.jetpackdemo.demo1_livedata.custom.login

import java.util.Random

/**
 * author: created by yuqiaodan on 2022/12/21 23:16
 * description:用户Model
 */
class UserModel {

    companion object {
        const val STATUS_LOADING = 0
        const val STATUS_LOGIN_SUC = 1
        const val STATUS_LOGIN_FAIL = 2
    }

    val api by lazy {
        Api()
    }

    fun doLogin(account: String, password: String, block: (Int) -> Unit) {

        block.invoke(STATUS_LOADING)


        val value: Int = Random().nextInt(2)

        when (value) {
            0 -> {
                block.invoke(STATUS_LOGIN_SUC)
            }
            1 -> {
                block.invoke(STATUS_LOGIN_FAIL)
            }

        }
    }


    fun checkUserStatus(account: String, block: (Int) -> Unit) {
        //1-已登录 0-未登录
        block.invoke(Random().nextInt(2))
    }


    interface LoginCallback {

        fun onLoading()

        fun onLoginSuccess()

        fun onLoginFail()
    }


}