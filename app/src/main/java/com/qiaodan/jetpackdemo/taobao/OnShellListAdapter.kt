package com.qiaodan.jetpackdemo.taobao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qiaodan.jetpackdemo.R
import com.qiaodan.jetpackdemo.taobao.api.bean.OnShellBean

/**
 * author: created by yuqiaodan on 2023/1/3 17:46
 * description:促销商品列表UI适配器
 */
class OnShellListAdapter : RecyclerView.Adapter<OnShellListAdapter.InnerHolder>() {


    private val mContent = arrayListOf<OnShellBean.TbkDgOptimusMaterialResponse.ResultList.MapData>()

    fun setData(newList: List<OnShellBean.TbkDgOptimusMaterialResponse.ResultList.MapData>) {
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