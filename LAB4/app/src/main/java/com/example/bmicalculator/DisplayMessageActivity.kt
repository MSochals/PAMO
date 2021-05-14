package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayMessageActivity : AppCompatActivity() {
    private var resultTextView2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val intent = intent
        val bmiMessage = intent.getStringExtra(SecondaryActivity.Companion.EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        resultTextView2 = findViewById(R.id.resultTextView)
        resultTextView2!!.setText(bmiMessage)
    }
}