package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.qiaodan.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_recommend.*

class OnSellActivity : AppCompatActivity() {
    private val mViewModel by lazy {
        ViewModelProvider(this).get(OnSellViewModel::class.java)
    }


    private val mAdapter by lazy {
        OnShellListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        initView()
        initObserver()
        mViewModel.loadContent()


    }

    private fun initView() {


        content_list_rv.layoutManager = LinearLayoutManager(this)

        content_list_rv.adapter = mAdapter

    }


    private fun initObserver() {
        mViewModel.contentList.observe(this, Observer { list ->
            //更新最新列表内容
            mAdapter.setData(list)
        })
    }


}