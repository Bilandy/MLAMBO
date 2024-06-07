package com.example.mlambo


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var buttonStart: Button
    private lateinit var buttonExit: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        buttonStart = findViewById(R.id.buttonStart)
        buttonExit = findViewById(R.id.buttonExit)

        buttonStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonExit.setOnClickListener {
            finish()
        }
    }
}
