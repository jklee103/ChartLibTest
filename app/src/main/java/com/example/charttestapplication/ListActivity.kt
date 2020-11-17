package com.example.charttestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        var tablayout = findViewById<TabLayout>(R.id.tabs)
        var selectFragment: Fragment = SetMainFragment()
        supportFragmentManager.beginTransaction().add(R.id.frame, selectFragment).commit()
        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                var position = tab?.position
                when(position){
                    0 -> selectFragment = SetMainFragment()
                    1-> selectFragment = SetOrderFragment()
                    2 -> selectFragment = SetShowFragment()
                    else -> selectFragment = SetMainFragment()
                }

                supportFragmentManager.beginTransaction().replace(R.id.frame, selectFragment).commit()
            }

        })
    }
}