package com.mercedes_benz.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mercedes_benz.R

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
        replaceFragment(carsTypeFragment)

        sedanItem = view.findViewById(R.id.sedanCoupesTextView)
        cabrioletItem = view.findViewById(R.id.cabrioletRoadstersTextView)

        sedanItem.setOnClickListener {
            replaceFragment(carsTypeFragment)
        }

        cabrioletItem.setOnClickListener {
            replaceFragment(menuFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = context.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.inner_fragment_container, fragment)
        transaction.commit()
    }
}