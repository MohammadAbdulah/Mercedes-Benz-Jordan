package com.mercedes_benz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var loginAsGuest: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginAsGuest = findViewById(R.id.loginAsGuestTextView)
        loginAsGuest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.loginAsGuestTextView -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}