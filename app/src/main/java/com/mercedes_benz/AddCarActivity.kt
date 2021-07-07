package com.mercedes_benz

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class AddCarActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var title: TextView
    private var dateFormatter = SimpleDateFormat("YYYY", Locale.US)
    private lateinit var datePickerButton: EditText
    private lateinit var leftCarNumber: EditText
    private lateinit var rightCarNumber: EditText
    private lateinit var chassisNumber: EditText
    private lateinit var carModel: EditText
    private lateinit var mileage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        title = findViewById(R.id.top_actionbar_title)
        title.text = "Add a Car"

        leftCarNumber = findViewById(R.id.leftCarNumberEditText)
        rightCarNumber = findViewById(R.id.rightCarNumberEditText)
        chassisNumber = findViewById(R.id.chassisNumberEditText)
        carModel = findViewById(R.id.carModelButton)
        mileage = findViewById(R.id.mileageEditText)
        datePickerButton = findViewById(R.id.datePickerButton)

        datePickerButton.setOnClickListener(this)
    }

    override fun onClick(p: View?) {
        when (p?.id) {
            R.id.carModelButton -> {
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

            R.id.addCarButton -> {
                if( TextUtils.isEmpty(leftCarNumber.text.toString()) ||
                    TextUtils.isEmpty(rightCarNumber.text.toString()) ||
                    TextUtils.isEmpty(chassisNumber.text.toString()) ||
                    TextUtils.isEmpty(carModel.text.toString()) ||
                    TextUtils.isEmpty(mileage.text.toString())) {
                    Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
                    return
                }


            }
        }
    }
}