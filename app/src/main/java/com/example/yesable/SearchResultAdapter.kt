package com.example.yesable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yesable.databinding.ItemSearchResultBinding

class SearchResultAdapter(val searchResultList: List<DataSearchResult>):RecyclerView.Adapter<SearchResultAdapter.MainViewHolder>(){

    inner class MainViewHolder(val itemBinding: ItemSearchResultBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(searchResultItem:DataSearchResult){
            // noti 값이 공백이 아닌 경우에만 표시
            if (searchResultItem.noti.isNotBlank()) {
                itemBinding.itemNoti1.text = searchResultItem.noti
                itemBinding.itemNoti1.visibility = View.VISIBLE
            } else {
                itemBinding.itemNoti1.visibility = View.GONE
            }

            itemBinding.itemNoti2.text = searchResultItem.comp
            itemBinding.itemNoti3.text = searchResultItem.title
            itemBinding.itemNoti4.text = searchResultItem.sub
            itemBinding.itemNoti5.setImageResource(searchResultItem.heart)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun getItemCount(): Int {
        return searchResultList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val sr = searchResultList[position]
        holder.bindItem(sr)
    }
}