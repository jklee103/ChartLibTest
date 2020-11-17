package com.example.charttestapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class OrderRecyclerAdapter(var items: ArrayList<ExString>): RecyclerView.Adapter<OrderRecyclerAdapter.Holder>(), ItemMoveCallback.ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_order, parent, false)
        var holder = Holder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = items[position].name
    }

    override fun onItemMove(fromPos: Int, targetPos: Int) {
        if (fromPos < targetPos) {
            for (i in fromPos until targetPos) {
                Collections.swap(items, i, i+1)
            }
        }else{
            for (i in fromPos until targetPos)
            {
                Collections.swap(items, i, i-1)
            }
        }
        notifyItemMoved(fromPos, targetPos)
    }

    override fun onItemDismiss(pos: Int) {
        items.removeAt(pos)
        notifyItemRemoved(pos)

    }
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_order)
    }


}