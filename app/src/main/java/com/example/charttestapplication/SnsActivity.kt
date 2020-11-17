package com.example.charttestapplication

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sns.*
import java.text.SimpleDateFormat
import java.util.*


class SnsActivity : AppCompatActivity() {
    var myCalendar = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sns)


        a_sns_spn_select.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{ //스피너 값 골랐을때
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }
        val date =
            OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, monthOfYear)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateLabel()
            }
        a_sns_tv_date.setOnClickListener {
            Log.e("textview", "click")
            DatePickerDialog(
                this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show() }

    }
    fun updateLabel() {
        var myFormat = "yyyy.MM.dd"; //In which you need put here
        var sdf = SimpleDateFormat(myFormat, Locale.US);

        a_sns_tv_date.setText(sdf.format(myCalendar.getTime()));
    }
}