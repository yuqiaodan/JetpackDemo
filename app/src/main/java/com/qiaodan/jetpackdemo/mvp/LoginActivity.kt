package com.qiaodan.jetpackdemo.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.qiaodan.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginPresenter.LoginCallback {


    private var isUserCanUse = true
    private val loginPresenter by lazy {
        LoginPresenter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListener()
    }


    private fun initListener() {
        btn_login.setOnClickListener {
            toLogin()
        }

        edit_account.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                //检查当前是否已注册
                loginPresenter.checkAccountState(s.toString(), object : LoginPresenter.OnCheckUserCallback {
                    override fun onCanUse() {
                        isUserCanUse = true
                        tv_login_status.text = "账户可用"
                    }

                    override fun onCanNotUse() {
                        isUserCanUse = false
                        tv_login_status.text = "账户不可用"
                    }
                }
                )
            }
        })

    }


    /***
     * 处理登录逻辑
     * */
    private fun toLogin() {
        //登录逻辑
        //检查输入内容
        val account = edit_account.text.toString()
        val password = edit_password.text.toString()
        loginPresenter.doLogin(account, password, this)
        //禁止按钮点击 防止重复提交
        //btn_login.isClickable = false
    }

    override fun onLoading() {
        tv_login_status.text = "登陆中"
    }

    override fun onLoginSuccess() {
        tv_login_status.text = "登录成功"
    }

    override fun onLoginFail(msg: String) {
        tv_login_status.text = "登录失败：$msg"
    }

    override fun onEditError(msg: String) {
        tv_login_status.text = "输入错误：$msg"
    }
}