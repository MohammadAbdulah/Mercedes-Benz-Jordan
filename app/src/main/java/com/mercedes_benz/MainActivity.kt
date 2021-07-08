package com.mercedes_benz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mercedes_benz.fragments.CarsFragment
import com.mercedes_benz.fragments.MenuFragment
import com.mercedes_benz.fragments.NotificationFragment
import com.mercedes_benz.fragments.ServicesFragment
import com.mercedes_benz.model.FragmentFunctions.Companion.replaceFragment

class MainActivity : AppCompatActivity() {
    private val carsFragment = CarsFragment()
    private val servicesFragment = ServicesFragment()
    private val notificationFragment = NotificationFragment()
    private val menuFragment = MenuFragment()
    private lateinit var callImageView: ImageView
    private lateinit var bottomActionbar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(carsFragment, R.id.fragment_container, this)

        callImageView = findViewById(R.id.rightImageView)
        bottomActionbar = findViewById(R.id.bottom_actionbar)

        callImageView.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "065805050")))
        }
        bottomActionbar.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.ic_car -> {
                    replaceFragment(carsFragment, R.id.fragment_container, this)
                    true
                }
                R.id.ic_service -> {
                    replaceFragment(servicesFragment, R.id.fragment_container, this)
                    true
                }
                R.id.ic_notification -> {
                    replaceFragment(notificationFragment, R.id.fragment_container, this)
                    true
                }
                R.id.ic_menu -> {
                    replaceFragment(menuFragment, R.id.fragment_container, this)
                    true
                }
                else -> false
            }
        }
    }
}