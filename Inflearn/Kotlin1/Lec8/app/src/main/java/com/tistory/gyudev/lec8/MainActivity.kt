package com.tistory.gyudev.lec8

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dateStart = ""
        var dateEnd = ""

        val calendarStart = Calendar.getInstance()
        val calendarEnd = Calendar.getInstance()

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnEnd = findViewById<Button>(R.id.btnEnd)
        val textView = findViewById<TextView>(R.id.textView)


        btnStart.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
//                    dateStart = "${p1} + ${p2} + ${p3}"
                    //1,2,3 차례로 year, month, dayOfMonth
                    //month는 0부터 시작이라 +1해줘야됨
                    dateStart = p1.toString() + (p2 + 1).toString() + p3.toString()

                    calendarStart.set(p1, p2+1, p3)
                }
            }, year, month, date)
            dlg.show()
        }
        btnEnd.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
//                    dateStart = "${p1} + ${p2} + ${p3}"
                    //1,2,3 차례로 year, month, dayOfMonth
                    //month는 0부터 시작이라 +1해줘야됨
                    dateEnd = p1.toString() + (p2 + 1).toString() + p3.toString() //버그남

                    calendarEnd.set(p1, p2+1, p3)

                    val date = TimeUnit.MILLISECONDS.toDays(calendarEnd.timeInMillis - calendarStart.timeInMillis)

//                    val dDay = dateEnd.toInt() - dateStart.toInt() + 1 // the reason plus one, to include today too
//                    textView.text = dDay.toString()
                    textView.text = date.toString()
                }
            }, year, month, date)
            dlg.show()
        }

    }
}