package com.taewoo.sololifeapp.contentList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taewoo.sololifeapp.R

class ContentRVAdapter(val context: Context, val items : ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.ViewHolder>() {

    // 아이템 레이아웃
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {
        holder.bindItems(items[position])
    }

    // 아이템 갯수
    override fun getItemCount(): Int {
        return items.size
    }

    // 아이템 내용물
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)   {

        fun bindItems(item: ContentModel) {

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)

            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)

        }
    }
}