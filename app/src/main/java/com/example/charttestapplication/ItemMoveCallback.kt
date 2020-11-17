package com.example.charttestapplication

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemMoveCallback(adapter: ItemTouchHelperAdapter) : ItemTouchHelper.Callback() {
    var adapter:ItemTouchHelperAdapter = adapter

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        var flagSwipe = ItemTouchHelper.START or ItemTouchHelper.END //아이템 정렬따라 방향 바꾸삼
        var flagDrag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        return makeMovementFlags(flagDrag, flagSwipe)
        //리턴값에서 뺴고싶은 동작 0 주면 됨
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition())
        return true
    }
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onItemDismiss(viewHolder.getAdapterPosition())
    }

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    interface ItemTouchHelperAdapter {
        fun onItemMove(fromPos: Int, targetPos: Int): Unit
        fun onItemDismiss(pos: Int): Unit
    }

}