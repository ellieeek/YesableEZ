package com.example.yesable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yesable.databinding.ItemNotificationBinding

class NotificationAdapter(val notiList: List<DataNotification>):RecyclerView.Adapter<NotificationAdapter.MainViewHolder>(){

    inner class MainViewHolder(val itemBinding: ItemNotificationBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
            fun bindItem(notiItem:DataNotification){
                itemBinding.itemNoti1.text = notiItem.noti
                itemBinding.itemNoti2.text = notiItem.comp
                itemBinding.itemNoti3.text = notiItem.title
                itemBinding.itemNoti4.text = notiItem.sub

                // d-day가 "마감"인 경우
                if (notiItem.dday == "마감") {
                    itemBinding.itemNoti5.text = "마감"
                    itemBinding.itemNoti5.setTextColor(itemView.context.getColor(R.color.dark_gray)) // 회색 텍스트
                    itemBinding.root.setBackgroundResource(R.drawable.card_border_gray) // 회색 테두리 및 배경 설정
                } else {
                    // 일반 상태인 경우
                    itemBinding.itemNoti5.text = notiItem.dday
                    itemBinding.root.setBackgroundResource(R.drawable.card_border) // 기본 테두리 및 배경 설정
                }

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemNotificationBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun getItemCount(): Int {
        return notiList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
         val noti = notiList[position]
        holder.bindItem(noti)
    }
}