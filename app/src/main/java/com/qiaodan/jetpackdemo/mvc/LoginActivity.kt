package com.qiaodan.jetpackdemo.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.qiaodan.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    private val userModel by lazy {
        UserModel()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            toLogin()
        }
    }


    /***
     * 处理登录逻辑
     * */
    private fun toLogin() {

        //登录逻辑
        //检查输入内容
        val account = edit_account.text.toString()
        val password = edit_password.text.toString()


        if (TextUtils.isEmpty(account)) {
            return

        }

        if (TextUtils.isEmpty(password)) {
            return
        }

        userModel.checkUserStatus(account) {




        }


        //异步方式 登录
        userModel.doLogin(object : UserModel.LoginCallback {
            override fun onLoading() {
                tv_login_status.text = "登录中..."
            }

            override fun onLoginSuccess() {
                tv_login_status.text = "登录成功"
                btn_login.isClickable = true
            }

            override fun onLoginFail() {
                tv_login_status.text = "登录失败"
                btn_login.isClickable = true
            }
        })

        //禁止按钮点击 防止重复提交
        btn_login.isClickable = false
    }
}