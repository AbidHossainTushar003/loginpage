package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityLinkedInBinding

class LinkedIn : AppCompatActivity() {

    private lateinit var binding: ActivityLinkedInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLinkedInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LinkedIn)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnsignIn.setOnClickListener {
            startActivity(Intent(this, FacebookLogin::class.java))
            Toast.makeText(this, "Going to Facebook Login Page", Toast.LENGTH_SHORT).show()
        }

        binding.google.setOnClickListener {
            Toast.makeText(this, "Continue With Google", Toast.LENGTH_LONG).show()
        }

        binding.facebook.setOnClickListener {
            Toast.makeText(this,"Continue with Facebook", Toast.LENGTH_SHORT).show()
        }
    }
}