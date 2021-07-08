package com.mercedes_benz.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mercedes_benz.R
import com.mercedes_benz.model.FragmentFunctions.Companion.replaceFragment

class CarsFragment : Fragment() {
    lateinit var context: AppCompatActivity
    private val carsTypeFragment =  CarsTypeFragment()
    private val menuFragment =  MenuFragment()
    private lateinit var sedanItem: TextView
    private lateinit var cabrioletItem: TextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context as AppCompatActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replaceFragment(carsTypeFragment, R.id.inner_fragment_container, context)

        sedanItem = view.findViewById(R.id.sedanCoupesTextView)
        cabrioletItem = view.findViewById(R.id.cabrioletRoadstersTextView)

        sedanItem.setOnClickListener {
            replaceFragment(carsTypeFragment, R.id.inner_fragment_container, context)
        }

        cabrioletItem.setOnClickListener {
            replaceFragment(menuFragment, R.id.inner_fragment_container, context)
        }
    }
}