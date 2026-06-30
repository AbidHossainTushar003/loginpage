package com.example.login

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnFacebook.setOnClickListener {
            startActivity(Intent(this, FacebookLogin::class.java))
        }

        binding.btnInstagram.setOnClickListener {
            startActivity(Intent(this, InstaLogin::class.java))
        }

        binding.btnTwitter.setOnClickListener {
            startActivity(Intent(this, XLogin::class.java))
        }

       binding.btnLinkedIn.setOnClickListener {

           Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
           val intent = Intent(this@MainActivity , LinkedIn::class.java)
           startActivity(intent)
        }
    }
}