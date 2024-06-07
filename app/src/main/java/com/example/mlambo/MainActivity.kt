package com.example.mlambo



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextDay: EditText
    private lateinit var editTextMorning: EditText
    private lateinit var editTextAfternoon: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonViewDetails: Button
    private lateinit var buttonClear: Button

    private val days = mutableListOf<String>()
    private val morningScreenTimes = mutableListOf<Int>()
    private val afternoonScreenTimes = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextDay = findViewById(R.id.editTextDay)
        editTextMorning = findViewById(R.id.editTextMorning)
        editTextAfternoon = findViewById(R.id.editTextAfternoon)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonViewDetails = findViewById(R.id.buttonViewDetails)
        buttonClear = findViewById(R.id.buttonClear)

        buttonAdd.setOnClickListener {
            addData()
        }

        buttonViewDetails.setOnClickListener {
            viewDetails()
        }

        buttonClear.setOnClickListener {
            clearData()
        }
    }

    private fun addData() {
        val day = editTextDay.text.toString()
        val morningTime = editTextMorning.text.toString().toIntOrNull()
        val afternoonTime = editTextAfternoon.text.toString().toIntOrNull()

        if (day.isBlank() || morningTime == null || afternoonTime == null) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show()
            return
        }

        days.add(day)
        morningScreenTimes.add(morningTime)
        afternoonScreenTimes.add(afternoonTime)

        Toast.makeText(this, "Data added", Toast.LENGTH_SHORT).show()
    }

    private fun viewDetails() {
        val intent = Intent(this, DetailedViewActivity::class.java)
        intent.putStringArrayListExtra("days", ArrayList(days))
        intent.putIntegerArrayListExtra("morningScreenTimes", ArrayList(morningScreenTimes))
        intent.putIntegerArrayListExtra("afternoonScreenTimes", ArrayList(afternoonScreenTimes))
        startActivity(intent)
    }

    private fun clearData() {
        days.clear()
        morningScreenTimes.clear()
        afternoonScreenTimes.clear()
        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
    }
}
