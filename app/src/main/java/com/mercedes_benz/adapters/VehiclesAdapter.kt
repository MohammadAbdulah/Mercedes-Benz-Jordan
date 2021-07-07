package com.mercedes_benz.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mercedes_benz.data.VehiclesData
import com.mercedes_benz.R
import com.mercedes_benz.VehicleDetailsActivity

class VehiclesAdapter(private val vehiclesList: ArrayList<VehiclesData>) :
    RecyclerView.Adapter<VehiclesAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun getItemCount(): Int = vehiclesList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_vehicles, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vehicleImage.setImageResource(R.mipmap.car)
        holder.itemView.setOnClickListener{v ->
            v.context.startActivity(Intent(context, VehicleDetailsActivity::class.java))
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vehicleImage: ImageView = view.findViewById(R.id.vehicleImageView)
    }
}