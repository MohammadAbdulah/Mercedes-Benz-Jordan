package com.mercedes_benz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mercedes_benz.fragments.CarsFragment
import com.mercedes_benz.fragments.MenuFragment
import com.mercedes_benz.fragments.NotificationFragment
import com.mercedes_benz.fragments.ServicesFragment

class MainActivity : AppCompatActivity() {
    private val carsFragment = CarsFragment()
    private val servicesFragment = ServicesFragment()
    private val notificationFragment = NotificationFragment()
    private val menuFragment = MenuFragment()
    private lateinit var bottomActionbar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(carsFragment)

        bottomActionbar = findViewById(R.id.bottom_actionbar)
        bottomActionbar.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.ic_car -> {
                    replaceFragment(carsFragment)
                    true
                }
                R.id.ic_service -> {
                    replaceFragment(servicesFragment)
                    true
                }
                R.id.ic_notification -> {
                    replaceFragment(notificationFragment)
                    true
                }
                R.id.ic_menu -> {
                    replaceFragment(menuFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}