package com.mercedes_benz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercedes_benz.R
import com.mercedes_benz.model.MyCarsModel

class MyCarsAdapter(private val myCarsList: ArrayList<MyCarsModel>) :
    RecyclerView.Adapter<MyCarsAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun getItemCount(): Int = myCarsList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.my_cars_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carModel.text = myCarsList[position].model
        holder.carNumber.text = myCarsList[position].carNumber
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val carNumber: TextView = view.findViewById(R.id.carNumberTextView)
        val carModel: TextView = view.findViewById(R.id.carModelTextView)
    }
}