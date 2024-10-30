package com.example.yesable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainManySupportAdapter(private val dataList: List<DataMainManySupportItem>) :
    RecyclerView.Adapter<MainManySupportAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemType: TextView = itemView.findViewById(R.id.item_type)
        val itemName: TextView = itemView.findViewById(R.id.item_name)
        val itemTitle: TextView = itemView.findViewById(R.id.item_title)
        val itemHeart: ImageView = itemView.findViewById(R.id.item_heart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_many_support, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.itemType.text = item.type
        holder.itemName.text = item.name
        holder.itemTitle.text = item.title

        // 찜하기 상태에 따른 아이콘 설정
        if (item.isHeartClicked) {
            holder.itemHeart.setImageResource(R.drawable.icon_heart_clicked)
        } else {
            holder.itemHeart.setImageResource(R.drawable.icon_heart)
        }

        // 하트 클릭 리스너 설정
        holder.itemHeart.setOnClickListener {
            item.isHeartClicked = !item.isHeartClicked  // 상태 반전
            notifyItemChanged(position)  // 아이템 갱신
        }
    }

    override fun getItemCount(): Int = dataList.size
}