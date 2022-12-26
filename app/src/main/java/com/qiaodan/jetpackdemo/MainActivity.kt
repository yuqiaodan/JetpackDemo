package com.qiaodan.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.qiaodan.jetpackdemo.custom.login.LoginActivity
import com.qiaodan.jetpackdemo.main.HomeActivity
import com.qiaodan.jetpackdemo.custom.musiclist.MusicActivity
import com.qiaodan.jetpackdemo.custom.player.FlowPlayerActivity
import com.qiaodan.jetpackdemo.custom.player.PlayerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login_page.setOnClickListener(this)
        btn_play_page.setOnClickListener(this)
        btn_play_flow_page.setOnClickListener(this)
        btn_music_list_page.setOnClickListener(this)
        btn_home.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login_page -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            R.id.btn_play_page->{
                startActivity(Intent(this, PlayerActivity::class.java))
            }
            R.id.btn_play_flow_page->{
                startActivity(Intent(this, FlowPlayerActivity::class.java))

            }
            R.id.btn_music_list_page->{
                startActivity(Intent(this, MusicActivity::class.java))
            }

            R.id.btn_home->{
                startActivity(Intent(this, HomeActivity::class.java))

            }
        }
    }
}