package com.qiaodan.jetpackdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.demo3_databinding.binddemo.StudentActivity
import com.qiaodan.jetpackdemo.demo1_livedata.custom.login.LoginActivity
import com.qiaodan.jetpackdemo.demo1_livedata.custom.musiclist.MusicActivityTest
import com.qiaodan.jetpackdemo.demo1_livedata.custom.player.FlowPlayerActivity
import com.qiaodan.jetpackdemo.demo1_livedata.custom.player.PlayerActivityTest
import com.qiaodan.jetpackdemo.databinding.ActivityMainBinding
import com.qiaodan.jetpackdemo.demo1_livedata.home.HomeActivity
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.OnSellActivity
import com.qiaodan.jetpackdemo.demo3_databinding.mvvm.NewShellActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnLoginPage.setOnClickListener(this)
        binding.btnPlayPage.setOnClickListener(this)
        binding.btnPlayFlowPage.setOnClickListener(this)
        binding.btnMusicListPage.setOnClickListener(this)
        binding.btnHome.setOnClickListener(this)
        binding.btnTaobao.setOnClickListener(this)
        binding.btnStudent.setOnClickListener(this)
        binding.btnNewShell.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnLoginPage -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            binding.btnPlayPage -> {
                startActivity(Intent(this, PlayerActivityTest::class.java))
            }
            binding.btnPlayFlowPage -> {
                startActivity(Intent(this, FlowPlayerActivity::class.java))

            }
            binding.btnMusicListPage -> {
                startActivity(Intent(this, MusicActivityTest::class.java))
            }

            binding.btnHome -> {
                startActivity(Intent(this, HomeActivity::class.java))

            }
            binding.btnTaobao -> {
                startActivity(Intent(this, OnSellActivity::class.java))
            }
            binding.btnStudent->{
                startActivity(Intent(this, StudentActivity::class.java))
            }
            binding.btnNewShell->{
                startActivity(Intent(this, NewShellActivity::class.java))

            }
        }
    }
}