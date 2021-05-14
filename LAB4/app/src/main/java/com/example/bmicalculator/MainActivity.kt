package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun FirstScreen(view: View?) {
        val first = Intent(this, SecondaryActivity::class.java)
        startActivity(first)
    }

    fun QuizScreen(view: View?) {
        val quiz = Intent(this, QuizActivity::class.java)
        startActivity(quiz)
    }

    fun GraphScreen(view: View?) {
        val quiz = Intent(this, GraphActivity::class.java)
        startActivity(quiz)
    }
}