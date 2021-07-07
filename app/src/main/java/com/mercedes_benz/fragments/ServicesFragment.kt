package com.mercedes_benz.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mercedes_benz.AddCarActivity
import com.mercedes_benz.R
import com.mercedes_benz.adapters.MyCarsAdapter
import com.mercedes_benz.model.MyCarsModel

class ServicesFragment : Fragment() {
    private lateinit var adapter: MyCarsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var addCarButton: Button
    private val myCars: ArrayList<MyCarsModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPageData(view, myCars)
    }

    private fun setPageData(view: View, myCars: ArrayList<MyCarsModel>) {
        myCars.add(MyCarsModel("20-21321", 1, "A Class", 1, 1))
        myCars.add(MyCarsModel("20-21321", 1, "A Class", 1, 1))
        adapter = MyCarsAdapter(myCars)
        recyclerView = view.findViewById(R.id.myCarsRecyclerView)
        layoutManager = LinearLayoutManager(context?.applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

        addCarButton = view.findViewById(R.id.addCarButton)
        addCarButton.setOnClickListener {
            activity?.startActivity(Intent(activity, AddCarActivity::class.java))
        }
    }
}