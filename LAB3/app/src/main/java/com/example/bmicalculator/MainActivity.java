package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void FirstScreen(View view) {
        Intent first = new Intent(this, SecondaryActivity.class);
        startActivity(first);
    }

    public void QuizScreen(View view) {
        Intent quiz = new Intent(this, QuizActivity.class);
        startActivity(quiz);
    }

    public void GraphScreen(View view) {
        Intent quiz = new Intent(this, GraphActivity.class);
        startActivity(quiz);
    }
}