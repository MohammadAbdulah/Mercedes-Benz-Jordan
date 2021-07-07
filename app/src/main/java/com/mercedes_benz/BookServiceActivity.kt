package com.mercedes_benz

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class BookServiceActivity : AppCompatActivity(), View.OnClickListener {
    private var dateFormatter = SimpleDateFormat("dd MMMM YYYY", Locale.US)
    private lateinit var datePickerButton: EditText
    private lateinit var timePickerButton: EditText
    private lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_service)

        title = findViewById(R.id.top_actionbar_title)
        title.text = "Book a Service"

        datePickerButton = findViewById(R.id.datePickerButton)
        timePickerButton = findViewById(R.id.timePickerButton)

        datePickerButton.setOnClickListener(this)
        timePickerButton.setOnClickListener(this)
    }

    override fun onClick(p: View?) {
        when (p?.id) {
            R.id.datePickerButton -> {
                val getDate = Calendar.getInstance()
                val datePicker = DatePickerDialog(
                    this,
                    AlertDialog.THEME_HOLO_DARK,
                    DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                        val selectDate = Calendar.getInstance()
                        selectDate.set(Calendar.YEAR, i)
                        selectDate.set(Calendar.MONTH, i2)
                        selectDate.set(Calendar.DAY_OF_MONTH, i3)
                        val date = dateFormatter.format(selectDate.time)
                        datePickerButton.hint = ""
                        datePickerButton.setText(date)
                    },
                    getDate.get(Calendar.YEAR),
                    getDate.get(Calendar.MONTH),
                    getDate.get(Calendar.DAY_OF_MONTH)
                )
                datePicker.show()
            }

            R.id.timePickerButton -> {
                val myCalender = Calendar.getInstance()
                val hour = myCalender[Calendar.HOUR_OF_DAY]
                val minute = myCalender[Calendar.MINUTE]

                val myTimeListener =
                    OnTimeSetListener { view, hourOfDay, minute ->
                        timePickerButton.hint = ""
                        timePickerButton.setText("$hourOfDay : $minute")
                    }
                val timePickerDialog = TimePickerDialog(
                    this,
                    AlertDialog.THEME_HOLO_DARK,
                    myTimeListener,
                    hour,
                    minute,
                    true
                )
                timePickerDialog.show()
            }
        }
    }
}


