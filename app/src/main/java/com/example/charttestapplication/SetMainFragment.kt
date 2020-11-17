package com.example.charttestapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SetMainFragment : Fragment() {
    lateinit var rv: RecyclerView
    lateinit var items: ArrayList<ExString>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = getSamples()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_set_main, container, false)
        rv = view.findViewById(R.id.rv_main)
        var adapter = MainRecyclerAdapter(items)

        rv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv.adapter= adapter

        return view
    }

    companion object {

    }
}