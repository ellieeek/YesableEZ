package com.example.yesable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainMyHeartAdapter(private val dataList: List<DataMainMyHeart>) :
    RecyclerView.Adapter<MainMyHeartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyName: TextView = itemView.findViewById(R.id.item_noti2)
        val title: TextView = itemView.findViewById(R.id.item_noti3)
        val dDay: TextView = itemView.findViewById(R.id.item_noti5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_my_heart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.companyName.text = item.companyName
        holder.title.text = item.title
        holder.dDay.text = item.dDay
    }

    override fun getItemCount(): Int = dataList.size
}