package com.mercedes_benz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class VehicleDetailsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var phoneCall: ImageView
    private lateinit var whatsapp: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_details)

        phoneCall = findViewById(R.id.phoneCallIcon)
        whatsapp = findViewById(R.id.whatsappIcon)

        phoneCall.setOnClickListener(this)
        whatsapp.setOnClickListener(this)
    }

    override fun onClick(p: View?) {
        when (p?.id) {
            R.id.testDriveIcon -> {

            }

            R.id.phoneCallIcon -> {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "065805050")))
            }

            R.id.whatsappIcon -> {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=0795899084")))
            }
        }
    }
}