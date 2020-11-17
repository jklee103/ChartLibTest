package com.example.charttestapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.charttestapplication.databinding.ItemRvMainBinding

class MainRecyclerAdapter(var items: ArrayList<ExString>) :
    RecyclerView.Adapter<MainRecyclerAdapter.Holder>() {
    var checkpos = 0
    var oldcheck = 0

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        lateinit var binding: ItemRvMainBinding

        constructor(binding: ItemRvMainBinding) : this(binding.root) {
            this.binding = binding
            itemView.setOnClickListener(this)
        }

        var title: TextView = itemView.findViewById(R.id.tv_main)
        var check: ImageView = itemView.findViewById(R.id.iv_main)

        override fun onClick(p0: View?) {
            Log.e("main recycler", "click")

            checkpos = this.layoutPosition
            notifyDataSetChanged()
        }

        fun bind(item: ExString) {
            binding.setVariable(BR.listContent, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRvMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //holder.title.text = items[position].name

        val item = items[position]
        holder.bind(item)
        if (oldcheck != checkpos) {
            items[oldcheck].checked = false
            items[checkpos].checked = true
        }

        if (items[position].checked == true) {
            holder.check.visibility = View.VISIBLE
            oldcheck = position
        } else {
            holder.check.visibility = View.INVISIBLE
        }

    }
}