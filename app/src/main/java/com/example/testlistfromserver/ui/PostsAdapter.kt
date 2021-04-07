package com.example.testlistfromserver.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testlistfromserver.R
import com.example.testlistfromserver.model.Post


class PostsAdapter(
    private val values: List<Post>
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dev_exam, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.titleView.text = item.title
        holder.textView.text = item.text
        holder.dateLastModView.text = item.date

        Glide.with(holder.iconView.context)
            .load(item.image)
            .into(holder.iconView)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.title)
        val textView: TextView = view.findViewById(R.id.detTxt)
        val dateLastModView: TextView = view.findViewById(R.id.dateLastMod)
        val iconView: ImageView = view.findViewById(R.id.image)
    }
}