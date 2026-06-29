package com.example.login

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnFacebook).setOnClickListener {
            startActivity(Intent(this, FacebookLogin::class.java))
        }

        findViewById<Button>(R.id.btnInstagram).setOnClickListener {
            startActivity(Intent(this, InstaLogin::class.java))
        }

        findViewById<Button>(R.id.btnTwitter).setOnClickListener {
            startActivity(Intent(this, XLogin::class.java))
        }

        findViewById<Button>(R.id.btnLinkedIn).setOnClickListener {
            startActivity(Intent(this, LinkedIn::class.java))
        }
    }
}