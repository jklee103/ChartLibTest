package com.example.charttestapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShowRecyclerAdapter(var items: ArrayList<ExString>) :RecyclerView.Adapter<ShowRecyclerAdapter.Holder>() {
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_show)
        var toggle: Switch = itemView.findViewById(R.id.tb_show)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_show, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = items[position].name
        holder.toggle.isChecked = items[position].show
        if(items[position].checked){
            holder.toggle.visibility = View.INVISIBLE
        }
    }
}