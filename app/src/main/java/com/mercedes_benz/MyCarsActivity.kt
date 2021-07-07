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
    private lateinit var adapter: MyCarsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var addCarButton: Button
    private val myCars: ArrayList<MyCarsModel> = ArrayList()
    private lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cars)

        title = findViewById(R.id.top_actionbar_title)
        title.text = "My Cars"

        myCars.add(MyCarsModel("20-21321", 1, "A Class", 1, 1))
        myCars.add(MyCarsModel("20-21321", 1, "A Class", 1, 1))
        myCars.add(MyCarsModel("20-21321", 1, "A Class", 1, 1))
        myCars.add(MyCarsModel("20-21321", 1, "A Class", 1, 1))
        adapter = MyCarsAdapter(myCars)
        recyclerView = findViewById(R.id.myCarsRecyclerView)
        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

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