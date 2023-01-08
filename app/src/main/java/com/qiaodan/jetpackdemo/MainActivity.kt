package com.qiaodan.jetpackdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.qiaodan.jetpackdemo.binddemo.StudentActivity
import com.qiaodan.jetpackdemo.custom.login.LoginActivity
import com.qiaodan.jetpackdemo.custom.musiclist.MusicActivityTest
import com.qiaodan.jetpackdemo.custom.player.FlowPlayerActivity
import com.qiaodan.jetpackdemo.custom.player.PlayerActivityTest
import com.qiaodan.jetpackdemo.databinding.ActivityMainBinding
import com.qiaodan.jetpackdemo.home.HomeActivity
import com.qiaodan.jetpackdemo.taobao.OnSellActivity

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
        }
    }
}