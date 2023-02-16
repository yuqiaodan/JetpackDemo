package com.qiaodan.jetpackdemo.demo1_livedata.custom.login

import android.text.TextUtils

/**
 * author: created by yuqiaodan on 2022/12/22 22:05
 * description:
 */
class LoginPresenter {
    private val userModel by lazy {
        UserModel()
    }

    fun checkAccountState(account: String, param: OnCheckUserCallback) {
        if (account.length < 5) {
            param.onCanNotUse()
        } else {
            param.onCanUse()
        }
    }


    fun doLogin(account: String, password: String, callback: LoginCallback) {

        if (TextUtils.isEmpty(account)) {
            callback.onEditError("账号不能为空")
            return

        }

        if (TextUtils.isEmpty(password)) {
            callback.onEditError("密码不能为空")
            return
        }


        userModel.checkUserStatus(account) {
            //检查用户是否已登录 1-已登录 0-未登录
            if (it == 1) {
                callback.onLoginFail("警告：用户已登录 即将重新登录")
            }
        }

        //调用model层进行异步登录
        userModel.doLogin(
            account, password
        ) { code ->
            when (code) {
                UserModel.STATUS_LOADING -> {
                    callback.onLoading()
                }
                UserModel.STATUS_LOGIN_SUC -> {
                    callback.onLoginSuccess()
                }
                UserModel.STATUS_LOGIN_FAIL -> {
                    callback.onLoginFail("网络错误 请重试")
                }
            }
        }

    }


    interface LoginCallback {

        fun onLoading()

        fun onLoginSuccess()

        fun onLoginFail(msg: String)

        fun onEditError(msg: String)
    }


    interface OnCheckUserCallback {
        fun onCanUse()
        fun onCanNotUse()
    }

}