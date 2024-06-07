package com.example.mlambo

import android.annotation.SuppressLint


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {

    private lateinit var textViewDetails: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        textViewDetails = findViewById(R.id.textViewDetails)

        val days = intent.getStringArrayListExtra("days") ?: ArrayList()
        val morningScreenTimes = intent.getIntegerArrayListExtra("morningScreenTimes") ?: ArrayList()
        val afternoonScreenTimes = intent.getIntegerArrayListExtra("afternoonScreenTimes") ?: ArrayList()

        val details = StringBuilder()
        var totalScreenTime = 0

        for (i in days.indices) {
            val day = days[i]
            val morningTime = morningScreenTimes[i]
            val afternoonTime = afternoonScreenTimes[i]
            totalScreenTime += morningTime + afternoonTime
            details.append("Day: $day\nMorning: $morningTime mins\nAfternoon: $afternoonTime mins\n\n")
        }

        val averageScreenTime = if (days.isNotEmpty()) totalScreenTime / days.size else 0
        details.append("Average Screen Time: $averageScreenTime mins")

        textViewDetails.text = details.toString()
    }
}
