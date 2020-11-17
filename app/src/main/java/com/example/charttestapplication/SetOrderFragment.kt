package com.example.charttestapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SetOrderFragment : Fragment() {
    lateinit var rv : RecyclerView
    lateinit var items : ArrayList<ExString>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_set_order, container, false)
        items = getSamples()
        rv = view.findViewById(R.id.rv_order)

        var adapter = OrderRecyclerAdapter(items)

        var callback = ItemMoveCallback(adapter)
        var touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(rv)

        rv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv.adapter= adapter

        return view
    }

    companion object {

    }
}