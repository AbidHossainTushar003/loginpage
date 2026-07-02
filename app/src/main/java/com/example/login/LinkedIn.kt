package com.example.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityLinkedInBinding

class LinkedIn : AppCompatActivity() {

    private lateinit var binding: ActivityLinkedInBinding

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLinkedInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val loggedIn = sharedPreferences.getString("loggedIn", null)
        if (loggedIn != null) {
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, DataSave::class.java))
            finish()
        }
        binding.btnsignIn.setOnClickListener {

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                val editor = sharedPreferences.edit()
                editor.putString("loggedIn", "true")
                editor.apply()
                Toast.makeText(this, "Logged In Successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DataSave::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
                finish()
            }
        }

        binding.google.setOnClickListener {
            Toast.makeText(this, "Continue With Google", Toast.LENGTH_LONG).show()
        }

        binding.facebook.setOnClickListener {
            Toast.makeText(this,"Continue with Facebook", Toast.LENGTH_SHORT).show()
        }
    }
}