package com.mercedes_benz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mercedes_benz.adapters.MyCarsAdapter
import com.mercedes_benz.model.MyCarsModel

class MyCarsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var addCarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cars)

        addCarButton = findViewById(R.id.addCarButton)
        addCarButton.setOnClickListener(this)
    }

    override fun onClick(p: View?) {
        when (p?.id) {
            R.id.addCarButton -> {
                startActivity(Intent(this, AddCarActivity::class.java))
            }
        }
    }
}