package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FacebookLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_login)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this@FacebookLogin, LinkedIn::class.java))
        }
    }
}