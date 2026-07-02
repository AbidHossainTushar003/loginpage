package com.example.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityDataSaveBinding

class DataSave : AppCompatActivity() {

    private lateinit var binding: ActivityDataSaveBinding

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataSaveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val email = intent.getStringExtra("email")
        binding.tvUserEmail.text = email

        binding.btnLogout.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.remove("loggedIn")
            editor.apply()
            startActivity(Intent(this, LinkedIn::class.java))
            finish()
        }

    }
}