package com.mercedes_benz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mercedes_benz.R
import com.mercedes_benz.adapters.VehiclesAdapter
import com.mercedes_benz.data.VehiclesData

class CarsTypeFragment : Fragment() {
    private lateinit var adapter: VehiclesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private val vehiclesList: ArrayList<VehiclesData> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cars_type, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPageData(view, vehiclesList)
    }

    private fun setPageData(view: View, vehiclesList: ArrayList<VehiclesData>) {
        vehiclesList.add(VehiclesData())
        vehiclesList.add(VehiclesData())
        adapter = VehiclesAdapter(vehiclesList)
        recyclerView = view.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(context?.applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }
}