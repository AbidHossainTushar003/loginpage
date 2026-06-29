package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class DualLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dual_login)

        // Root layout
        val rootLayout = findViewById<ConstraintLayout>(R.id.DualLogin)

        // Edge-to-edge padding
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Views
        val btnMorning = findViewById<Button>(R.id.btnMorning)
        val btnNight = findViewById<Button>(R.id.btnNight)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        // Morning Theme
        btnMorning.setOnClickListener {
            rootLayout.setBackgroundResource(R.drawable.bg_gradient_morning)
        }

        // Night Theme
        btnNight.setOnClickListener {
            rootLayout.setBackgroundResource(R.drawable.bg_gradient_night)
        }

        // Login Button
        btnLogin.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Enter your email"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Enter your password"
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Welcome $email!",
                Toast.LENGTH_SHORT
            ).show()

            // Example:
            // startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}