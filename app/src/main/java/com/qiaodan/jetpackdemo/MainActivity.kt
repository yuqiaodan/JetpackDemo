package com.qiaodan.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.qiaodan.jetpackdemo.custom.login.LoginActivity
import com.qiaodan.jetpackdemo.home.HomeActivity
import com.qiaodan.jetpackdemo.custom.musiclist.MusicActivity
import com.qiaodan.jetpackdemo.custom.player.FlowPlayerActivity
import com.qiaodan.jetpackdemo.custom.player.PlayerActivity
import com.qiaodan.jetpackdemo.databinding.ActivityMainBinding
import com.qiaodan.jetpackdemo.taobao.OnSellActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLoginPage.setOnClickListener(this)
        binding.btnPlayPage.setOnClickListener(this)
        binding.btnPlayFlowPage.setOnClickListener(this)
        binding.btnMusicListPage.setOnClickListener(this)
        binding.btnHome.setOnClickListener(this)
        binding.btnTaobao.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnLoginPage -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            binding.btnPlayPage -> {
                startActivity(Intent(this, PlayerActivity::class.java))
            }
            binding.btnPlayFlowPage -> {
                startActivity(Intent(this, FlowPlayerActivity::class.java))

            }
            binding.btnMusicListPage -> {
                startActivity(Intent(this, MusicActivity::class.java))
            }

            binding.btnHome -> {
                startActivity(Intent(this, HomeActivity::class.java))

            }
            binding.btnTaobao -> {
                startActivity(Intent(this, OnSellActivity::class.java))

            }
        }
    }
}