package com.example.taskandroid.DatePicker


import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import java.util.Calendar


class Datepicker : AppCompatActivity() {

    lateinit var pickDateBtn: Button
    lateinit var selectedDateTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicker)

        pickDateBtn = findViewById(R.id.idBtnPickDate)
        selectedDateTV = findViewById(R.id.idTVSelectedDate)


        pickDateBtn.setOnClickListener {

            val c = Calendar.getInstance()


            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(

                this,
                { view, year, monthOfYear, dayOfMonth ->

                    selectedDateTV.text =
                        (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },

                year,
                month,
                day
            )
            datePickerDialog.show()
        }


    }
}