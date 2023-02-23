package com.qiaodan.jetpackdemo.demo3_databinding.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.databinding.ItemNewShellBinding
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellItem

/**
 * author: created by yuqiaodan on 2023/2/23 16:17
 * description:
 */
class NewShellListAdapter : RecyclerView.Adapter<NewShellListAdapter.ViewHolder>() {

    private val contentList by lazy {
        mutableListOf<OnShellItem>()
    }

    class ViewHolder(itemView: View, val itemBinding: ItemNewShellBinding) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //加载方式1：DataBindingUtil.inflate 注意不要选错布局 R.layout.item_new_shell
        val itemBinding = DataBindingUtil.inflate<ItemNewShellBinding>(LayoutInflater.from(parent.context), R.layout.item_new_shell, parent, false)
        return ViewHolder(itemBinding.root, itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //填充item数据
        val shellItem = contentList[position]
        holder.itemBinding.itemData = shellItem
    }

    override fun getItemCount(): Int {
        return contentList.size
    }


    fun setData(newData: List<OnShellItem>) {
        contentList.clear()
        contentList.addAll(newData)
        //这里是全部更新 最好使用部分更新
        notifyDataSetChanged()
    }


}