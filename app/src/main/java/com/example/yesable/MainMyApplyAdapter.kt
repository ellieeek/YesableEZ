package com.example.yesable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainMyApplyAdapter(private val dataList: List<DataMainMyApply>) :
    RecyclerView.Adapter<MainMyApplyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyName: TextView = itemView.findViewById(R.id.item_noti2)
        val title: TextView = itemView.findViewById(R.id.item_noti3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_my_apply, parent, false)  // 레이아웃 이름 수정
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.companyName.text = item.companyName
        holder.title.text = item.title
    }

    override fun getItemCount(): Int = dataList.size
}