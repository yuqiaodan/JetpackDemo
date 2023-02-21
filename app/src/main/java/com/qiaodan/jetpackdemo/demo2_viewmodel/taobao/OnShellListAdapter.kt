package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean.OnShellApiBean

/**
 * author: created by yuqiaodan on 2023/1/3 17:46
 * description:促销商品列表UI适配器
 */
class OnShellListAdapter : RecyclerView.Adapter<OnShellListAdapter.InnerHolder>() {


    private val mContent = arrayListOf<OnShellApiBean.TbkDgOptimusMaterialResponse.ResultList.OnShellItem>()

    fun setData(newList: List<OnShellApiBean.TbkDgOptimusMaterialResponse.ResultList.OnShellItem>) {
        mContent.clear()
        mContent.addAll(newList)
        notifyDataSetChanged()
    }


    class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_on_shell_list, parent, false)

        return InnerHolder(itemView)

    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {

        val item=mContent[position]

        holder.itemView.findViewById<TextView>(R.id.tv_title).text=item.title


    }

    override fun getItemCount(): Int {
       return mContent.size
    }

}