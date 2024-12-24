package com.taewoo.sololifeapp.contentList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taewoo.sololifeapp.R

class ContentRVAdapter(val items : ArrayList<String>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {

    // 아이템 레이아웃
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {
        holder.bindItems(items[position])
    }

    // 아이템 갯수
    override fun getItemCount(): Int {
        return items.size
    }

    // 아이템 내용물
    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView)   {

        fun bindItems(item: String) {


        }
    }
}