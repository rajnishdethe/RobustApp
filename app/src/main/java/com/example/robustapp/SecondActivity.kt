package com.example.robustapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        // Initialize views
        val home = findViewById<View>(R.id.home_card)
        val setting = findViewById<View>(R.id.setting_card)
        val search = findViewById<View>(R.id.search_card)
        val phone = findViewById<View>(R.id.phone_card)
        val tv = findViewById<View>(R.id.liveTv_card)
        val exist = findViewById<View>(R.id.exit_card)

        // Set click listeners for each card
        home.setOnClickListener {
            // Handle click for Home card
            val intent = Intent(this, HomeActivity::class .java)
            startActivity(intent)
        }

        setting.setOnClickListener {
            // Handle click for Setting card
        }

        search.setOnClickListener {
            // Handle click for Search card
        }

        phone.setOnClickListener {
            // Handle click for Phone card
            val intent = Intent(this, PhoneActivity::class.java)
            // Start the activity
            startActivity(intent)

        }

        tv.setOnClickListener {
            // Handle click for Live TV card
        }

        exist.setOnClickListener {
            // Handle click for Exit card
        }

        // Set the title text for the dashboard menu
        val dashboardTitle = findViewById<TextView>(R.id.textView)
        dashboardTitle.text = "Dashboard Menu"
    }
}







