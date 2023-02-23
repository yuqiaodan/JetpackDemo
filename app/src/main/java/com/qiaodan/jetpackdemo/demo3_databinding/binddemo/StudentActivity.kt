package com.qiaodan.jetpackdemo.demo3_databinding.binddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //获取Binding方式1（推荐）：DataBindingUtil.setContentView 不需要设置 setContentView(binding.root) 直接用于activity
        binding = DataBindingUtil.setContentView<ActivityStudentBinding>(this, R.layout.activity_student)

        //获取Binding方式2（推荐）：DataBindingUtil.inflate 需要设置 setContentView(binding.root) 一般用于fragment和adapter
        //binding = DataBindingUtil.inflate<ActivityStudentBinding>(layoutInflater, R.layout.activity_student,null,false)

        //获取Binding方式3：inflate方法 需要设置 setContentView(binding.root)
        //binding = ActivityStudentBinding.inflate(layoutInflater)

        binding.user = User("张三", 18, User.Gender.MAN)

    }
}