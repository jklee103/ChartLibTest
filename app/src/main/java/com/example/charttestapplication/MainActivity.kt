package com.example.charttestapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var entries = arrayListOf<Entry>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineChart.data = LineData()
        var data = lineChart.data
        data.addDataSet(createSet(setDefaultNum()))

        setChart()

        btn1.setOnClickListener {
            Log.e("btn","click")
            data.removeDataSet(0)
            data.addDataSet(createSet(getRandomNum()))
            lineChart.invalidate()
        }
        btn2.setOnClickListener {
            var intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            var intent = Intent(applicationContext, SnsActivity::class.java)
            startActivity(intent)
        }

    }
    fun setDefaultNum(): ArrayList<Entry> {
        entries.add(Entry(0f, 10f))
        entries.add(Entry(1f, 20f))
        entries.add(Entry(2f, 0f))
        entries.add(Entry(3f, 40f))
        entries.add(Entry(4f, 30f))
        entries.add(Entry(5f, 80f))
        return entries
    }
    fun setChart() {
        val xAxis = lineChart.xAxis

        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            textSize = 10f //float 형태로
            granularity = 1f
            axisMinimum = -0.5f //시작값(패딩줄려고)
            axisMaximum = (((entries.size-1).toFloat()+0.5).toFloat())
            isGranularityEnabled = true
            setDrawGridLines(false)
            setDrawAxisLine(false)
            spaceMax = 0.5f //끝값 패딩

        }

        lineChart.apply {
            axisLeft.isEnabled = false

            axisRight.apply {
                axisMaximum = 100f//y축 최댓값
                setDrawAxisLine(false)
                enableGridDashedLine(10f,10f,10f)
                setDrawZeroLine(true)//첫줄 실선으로
                zeroLineWidth=1f
            }

            legend.apply { //범례
                textSize = 15f
                verticalAlignment = Legend.LegendVerticalAlignment.TOP // 수직 위
                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER //수평 가운데로
                orientation = Legend.LegendOrientation.HORIZONTAL // 범례랑 차트 수
                setDrawInside(false) //차트 안?
            }
            description = Description()
            description.text = ""
            isDoubleTapToZoomEnabled = false

        }


    }
    fun createSet(entries: List<Entry>): LineDataSet {
        var set = LineDataSet(entries,"%")
        set.apply {
            axisDependency = YAxis.AxisDependency.RIGHT//y축 기준이 오른쪽인지
            color = R.color.colorPrimary
            //valueTextSize = 10f
            setDrawValues(false) // 안에 데이터값 표시
            lineWidth = 2f
            setDrawCircles(false)
            //circleRadius = 0f
            fillAlpha = 0
            fillColor = R.color.colorPrimaryDark
            highLightColor = Color.BLACK

        }
        return set
    }
    fun getRandomNum(): ArrayList<Entry> {
        entries.clear()
        var random = Random()
        for(i in 0..5){

            entries.add(Entry(i.toFloat(), (random.nextInt(11)*10).toFloat() ))
        }
        return entries
    }
}