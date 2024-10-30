package com.example.yesable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yesable.databinding.ItemRecruitBinding

class RecruitAdapter(val recruitList: List<DataRecruit>):RecyclerView.Adapter<RecruitAdapter.MainViewHolder>(){

    inner class MainViewHolder(val itemBinding: ItemRecruitBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(recruitItem:DataRecruit){
            // noti 값이 공백이 아닌 경우에만 표시
            if (recruitItem.noti.isNotBlank()) {
                itemBinding.itemNoti1.text = recruitItem.noti
                itemBinding.itemNoti1.visibility = View.VISIBLE
            } else {
                itemBinding.itemNoti1.visibility = View.GONE
            }

            itemBinding.itemNoti2.text = recruitItem.comp
            itemBinding.itemNoti3.text = recruitItem.title
            itemBinding.itemNoti4.text = recruitItem.sub
            itemBinding.itemNoti5.setImageResource(recruitItem.heart)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemRecruitBinding.inflate(LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun getItemCount(): Int {
        return recruitList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val recruit = recruitList[position]
        holder.bindItem(recruit)
    }
}