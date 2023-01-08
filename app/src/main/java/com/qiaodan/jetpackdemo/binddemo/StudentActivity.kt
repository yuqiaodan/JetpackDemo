package com.qiaodan.jetpackdemo.binding.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qiaodan.jetpackdemo.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {

    private val binding by lazy {
        //获取Binding方式1：inflate方法 需要设置 setContentView(binding.root)
        ActivityStudentBinding.inflate(layoutInflater)
        //获取Binding方式2：DataBindingUtil.setContentView 不需要设置 setContentView(binding.root)
        //DataBindingUtil.setContentView<ActivityStudentBinding>(this, R.layout.activity_student)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.user = User("张三", 18, User.Gender.MAN)

    }
}