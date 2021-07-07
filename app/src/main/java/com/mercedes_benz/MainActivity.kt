package com.mercedes_benz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.mercedes_benz.data.VehiclesData
import com.mercedes_benz.adapters.VehiclesAdapter
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var vehiclesList: ArrayList<VehiclesData> = ArrayList()
    private lateinit var adapter: VehiclesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var sedan: TextView
    private lateinit var cabriolet: TextView
    private lateinit var suv: TextView
    private lateinit var pluginHybrid: TextView
    private lateinit var services: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sedan = findViewById(R.id.sedanCoupesTextView)
        cabriolet = findViewById(R.id.cabrioletRoadstersTextView)
        suv = findViewById(R.id.suvMpvTextView)
        pluginHybrid = findViewById(R.id.pluginHybridTextView)
        services = findViewById(R.id.serviceItem)

        sedan.setOnClickListener(this)
        cabriolet.setOnClickListener(this)
        suv.setOnClickListener(this)
        pluginHybrid.setOnClickListener(this)
        services.setOnClickListener(this)

        vehiclesList.add(VehiclesData())
        vehiclesList.add(VehiclesData())
        vehiclesList.add(VehiclesData())
        vehiclesList.add(VehiclesData())
        vehiclesList.add(VehiclesData())
        vehiclesList.add(VehiclesData())
        adapter = VehiclesAdapter(vehiclesList)
        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

//        getVehiclesJson("")
    }

    private fun getVehiclesJson(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                val gson = GsonBuilder().create()
                val vehiclesData = gson.fromJson(body, VehiclesData::class.java)
                Log.i("Response", body.toString())
                setPageData(vehiclesData)
            }

            override fun onFailure(call: Call, e: IOException) {
                Toast.makeText(baseContext, "Something went wrong!", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setPageData(vehiclesData: VehiclesData) {
        adapter = VehiclesAdapter(vehiclesList)
        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }

    override fun onClick(p: View?) {
        when (p?.id) {
            R.id.sedanCoupesTextView -> {

            }

            R.id.cabrioletRoadstersTextView -> {

            }

            R.id.suvMpvTextView -> {

            }

            R.id.pluginHybridTextView -> {

            }

            R.id.serviceItem -> {
                startActivity(Intent(this, MyCarsActivity::class.java))
            }
        }
    }
}